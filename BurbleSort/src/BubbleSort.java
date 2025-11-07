import java.util.Arrays;

public class BubbleSort {

    public void sort(int [] arr){
        int n= arr.length;

        //recorremos tyodoss los elementos del arreglo
        for(int i = 0; i<n-1;i++){
            for (int j = 0; j <n-1 -i; j++) {//recorremos los elementos adyacentes -1-i(por los que ya fueron recorridos )
                if(arr [j] > arr[j+1]){//pregunta si el elemento actua es mayor al siguiente
                    //se realiza el cambio de poscicion 
                    int temp = arr[j];
                    arr[j]=arr[j+1];//pasa el elemento actual al siguiente
                    arr[j+1]=temp;
                }
            }
        }

        System.out.println("Arreglo ordenado: ");
        System.out.println(Arrays.toString(arr));
    }
}
