
import java.util.ArrayDeque;
import java.util.Deque;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hola soy: Kevin Daniel Sandoval Rueda!");

//Inicializacion del stack
        Deque<String> webs = new ArrayDeque<>();
        webs.push("Pagina web : SISA UTEZ");
        webs.push("Pagina web : CODEC UTEZ");
        webs.push("Pagina web : UTEZ");
        System.out.println("Stack ahorita:" + webs);

        System.out.println("Quitamos la pagina: " +webs.pop());
        System.out.println("Estamos actualmente en el elemento: " +webs.peek());

        webs.push("Nueva pagina Web");
        System.out.println("Stack ahorita:" + webs);
    }
}
