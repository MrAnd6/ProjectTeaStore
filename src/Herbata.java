public abstract class Herbata {
    private String name;
    private String taste;
    private double ilosc;


    public Herbata(String name, String taste, int ilosc){
        this.name=name;
        this.taste=taste;
        this.ilosc=ilosc;
    }
    public String getHerb(){
        return name+taste;
    }
    public double getIlosc(){
        return ilosc;
    }

    public String getTaste() {
        return taste;
    }

    public void changeIlosc(double newIlosc){
        ilosc=newIlosc;
    }
    @Override
    public String toString() {
        return name+", smak: "+taste+", ilość: "+ilosc+" kg";
    }
}
