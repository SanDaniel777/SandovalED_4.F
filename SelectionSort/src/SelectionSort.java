import java.util.Arrays;

public class SelectionSort {

    public void sort(int [] arr){
        int n= arr.length;
        for(int i= 0; i<n-1;i++){
            int minIndex=i; //seleccionamos el primero como el menor 
            for(int j= i+1;j<arr.length;j++){//Iniciamos desde la parte no ordenada 
                if(arr[j]<arr[minIndex]){
                    minIndex=j; //indice del menor dentro de la parte ordenada 
                }
            }
            //Intercambio de posicion (pasa el menor a la posicion indicada de la parte ordenada)
            int temp=arr[minIndex];
            arr[minIndex]=arr[i];
            arr[i]=temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
