import java.util.HashMap;
import java.util.Map;

public class Cennik {
    private static Cennik instance=null;
    private Map<String, int[]> prices=new HashMap<>();
    private Cennik() {}

    public static Cennik pobierzCennik(){
        if(instance==null)
            instance=new Cennik();
        return instance;
    }
    public void dodaj(String name, String smak, int price){
        String herb=name+smak;
        prices.put(herb, new int[]{price});
    }
    public void dodaj(String name, int kg, String smak, int price1, int price2){
        String herb=name+smak;
        prices.put(herb, new int[]{kg,price1,price2});
    }
    public int pobierzCenu(Herbata herb){
        if(prices.containsKey(herb.getHerb())){
            int[] cena=prices.get(herb.getHerb());
            if(cena.length>1){
                return herb.getIlosc()<cena[0] ? cena[1] : cena[2];
            }
            else return cena[0];
        }
        else return -1;
    }
}
