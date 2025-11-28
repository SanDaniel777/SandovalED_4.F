
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        

        Map<Integer, String>map= new HashMap<>();

        map.put(1, "Mouse");
        map.put(2, "Teclado");
        map.put(3, "Monitor");
        map.put(1, "Mouse Gamer");//se sustituye por la key 1

        System.out.println(map);

        String data=  map.get(1);//obtener valor por key
        System.out.println(data);
        boolean exist= map.containsValue("teclado");//verificar si existe x objeto
        System.out.println("Hay un teclado: "+ exist);
        map.remove(1);

        for(Map.Entry<Integer, String>row:map.entrySet()){
            System.out.println("La key es: "+row.getKey()+" el valor es: "+row.getValue());
        }

        boolean existKey=map.containsKey(1);//verificar si existe x key
        System.out.println("existe la key 1? "+ existKey);

    }
}
