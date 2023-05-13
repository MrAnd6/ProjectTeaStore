import java.util.ArrayList;
import java.util.List;

public class Koszyk {
    private List<Herbata> kupuje=new ArrayList<>();
    private Cennik cennik;
    private Klient klient;
    public Koszyk(Klient klient){
        cennik=Cennik.pobierzCennik();
        this.klient=klient;
        for(Herbata herb : klient.pobierzListeZakupow().getLista()){
            if(cennik.pobierzCenu(herb)!=-1){
                kupuje.add(herb);
            }
        }
    }

    public List<Herbata> getKupuje() {
        return kupuje;
    }

    @Override
    public String toString() {
        String str= klient.toString()+":";
        if(kupuje.isEmpty())
            str+= " -- pusto";
        else {
            str+="\n";
            for (Herbata herb : kupuje)
                str+= herb.toString() + ", cena "+cennik.pobierzCenu(herb)+"\n";
        }
        return str;
    }

}
