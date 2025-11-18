import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc= new Scanner(System.in);
        System.out.println("Bienvenido ingresa el tamano del arreglo");
        int n= sc.nextInt();

        int[] arreglo= new int[n];

        for(int i = 0; i<n;i++){
            System.out.println("Ingresa un numero");
            arreglo[i]=sc.nextInt();
        }

        System.out.println("Arreglo original: ");
        for(int a:arreglo)System.out.print(a+ " ");

        BubbleSort sorting= new BubbleSort();
        sorting.sort(arreglo);

        System.out.println("Primer elemento: "+arreglo[0]);
        System.out.println("Ultimo elemento: "+arreglo[arreglo.length-1]);

        int diferencia=arreglo[arreglo.length-1]-arreglo[0];
        System.out.println("Diferencia: "+diferencia);
    }
}
