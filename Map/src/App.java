
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        

        Map<Integer, String>map= new HashMap<>();

        map.put(1, "Mouse");
        map.put(2, "Teclado");
        map.put(3, "Monitor");
        map.put(1, "Mouse Gamer");

        System.out.println(map);
    }
}
