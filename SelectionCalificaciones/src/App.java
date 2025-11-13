
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al sistema de calificaciones");
        System.out.println("Cuantas calificaciones desea agregar?");
        int n= sc.nextInt();
        sc.nextLine();
        String[] nombres= new String[n];
        int[] calificaciones= new int[n]; 

        for(int i = 0; i<n; i++){
            System.out.println("Nombre: ");
            nombres[i]= sc.nextLine();

            System.out.println("Calificaciones: ");
            calificaciones[i]=sc.nextInt();
            sc.nextLine();
        }

        sc.close();

        System.out.println("\nDatos No ordenados");
        for (int i = 0; i < n; i++) {
            System.out.println(nombres[i] + " : " + calificaciones[i]);
        }

        SelectionSort sorter = new SelectionSort();
        sorter.sort(nombres, calificaciones);
    }
}
