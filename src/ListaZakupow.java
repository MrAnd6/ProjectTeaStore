import java.util.ArrayList;
import java.util.List;

public class ListaZakupow {
    private List<Herbata> lista=new ArrayList<>();
    private Cennik cennik;
    private Klient klient;
    public ListaZakupow(Klient klient){
        cennik=Cennik.pobierzCennik();
        this.klient=klient;
    }

    public List<Herbata> getLista() {
        return lista;
    }

    @Override
    public String toString(){
        String str= klient.toString()+":";
        if(lista.isEmpty())
            str+= " -- pusto";
        else {
            str+="\n";
            for (Herbata herb : lista)
                str+= herb.toString() + ", cena "+cennik.pobierzCenu(herb)+"\n";
        }
        return str;
    }
}
