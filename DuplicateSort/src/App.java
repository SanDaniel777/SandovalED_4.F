import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {

        BubleSort bubleSort=new BubleSort();
          int[] arr = {4, 2, 9, 2, 4, 7, 1};

        System.out.println("Arreglo original:");
        System.out.println(Arrays.toString(arr));

    
        bubleSort.bubbleSort(arr);

        System.out.println("Arreglo después de ordenar:");
        System.out.println(Arrays.toString(arr));

        
        int[] sinDuplicados = bubleSort.quitarDuplicados(arr);

        System.out.println("Arreglo sin duplicados:");
        System.out.println(Arrays.toString(sinDuplicados));
    }
}
