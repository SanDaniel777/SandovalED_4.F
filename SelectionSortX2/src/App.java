
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int[]numeros=new int[10];
        int nPares=0;
        int nImpares=0;

        System.out.println("Ingresa 10 numeros enteros que desees:");

        for(int i=0; i<10; i++){
            System.out.println("Ingresa un numero: ");
            numeros[i]=sc.nextInt();
            if (numeros[i]%2==0){
                nPares++;
            }else{
                nImpares++;
            }
        }
        int[]pares=new int[nPares];
        int[]impares=new int[nImpares];
        int indexP=0;
        int indexI=0;
        
        for(int i=0; i<10;i++){
            if(numeros[i]%2==0){
                pares[indexP++]=numeros[i];
            }else{
                impares[indexI++]=numeros[i];
            }
        }

        SelectionSort sorting= new SelectionSort();
        System.out.println("Arreglo principal: ");
        for (int n : numeros) System.out.print(n + " ");

        System.out.println("\nArreglo de pares ya ordenado: ");
        sorting.sort(pares);

        System.out.println("Arreglo de impares ya ordenado: ");
        sorting.sort(impares);
        
    }
}
