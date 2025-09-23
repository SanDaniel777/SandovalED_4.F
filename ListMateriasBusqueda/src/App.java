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

        System.out.println("Escribe la materia que deseas buscar: ");
        String buscar = sc.nextLine();
        System.out.println("Buscar: "+buscar);
        if (lista.contiene(buscar)) {
            System.out.println("Resultado: Materia encontrada");
        }else{
            System.out.println("Resultado: Materia no encontrada");
        }
        sc.close();
    }
}
