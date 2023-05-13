import java.util.List;

public class Klient {

    private String name;
    private double money;
    private ListaZakupow lista;
    private Koszyk kosz;
    Cennik cennik;

    public Klient(String name, double money) {
        this.name = name;
        this.money = money;
        lista=new ListaZakupow(this);
        cennik=Cennik.pobierzCennik();
    }


    public void dodaj(Herbata herbata){
        lista.getLista().add(herbata);
    }
    public void przepakuj(Koszyk koszyk){
        kosz=koszyk;
        for(Herbata herb : kosz.getKupuje()){
            lista.getLista().remove(herb);
        }
    }

    public void zaplac(boolean prelew){
        if(fullPrice(prelew)<money){
            while(!kosz.getKupuje().isEmpty()) {
                Herbata herb=kosz.getKupuje().get(0);
                double price = cennik.pobierzCenu(herb) * herb.getIlosc();
                if (!prelew)
                    price += price * 0.02;
                money -= price;
                kosz.getKupuje().remove(herb);
            }
        }
        else {
            boolean hasMoney = true;
            double price = 0;
            while (hasMoney) {
                Herbata herb = kosz.getKupuje().get(0);
                price += cennik.pobierzCenu(herb) * 0.5;
                if (price == cennik.pobierzCenu(herb) * herb.getIlosc()) {
                    kosz.getKupuje().remove(herb);
                    if(!prelew)
                        price += price * 0.02;
                    money -= price;
                    price = 0;
                }
                if (price + cennik.pobierzCenu(herb) * 0.5 > money) {
                    hasMoney = false;
                    herb.changeIlosc(herb.getIlosc()-(price / cennik.pobierzCenu(herb)));
                    if(!prelew)
                        price += price * 0.02;
                    money -= price;

                }
            }
        }
    }
    private int fullPrice(boolean prelew){
        int price=0;
        for (Herbata herb : kosz.getKupuje())
            price+=cennik.pobierzCenu(herb)* herb.getIlosc();
        if(prelew)
            price+=price*0.02;
        return price;
    }
    public double pobierzPortfel(){
        return money;
    }
    public ListaZakupow pobierzListeZakupow() {
        return lista;
    }

    public Koszyk pobierzKoszyk() {
        return kosz;
    }

    @Override
    public String toString() {
        return name;
    }

}
