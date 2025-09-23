import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Materias Sandoval Kevin");
        Scanner sc = new Scanner(System.in);

        ListaMaterias lista = new ListaMaterias();
        lista.agregar("Fisica");
        lista.agregar("Calculo");
        lista.agregar("Apps Moviles");
        lista.agregar("Etica");
        lista.agregar("Programacion");

        lista.imprimir();




    }
}
