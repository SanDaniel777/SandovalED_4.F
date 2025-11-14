public class QuickSort {

    public void quickSort(int[] arr){
        quickSort(arr,0,arr.length-1);
    }

    private void quickSort(int [] arr, int low, int high){
        if(low<high){
            int pivot= partition(arr, low, high);//Realiza la particion del arreglo
            //Lllamados recursivos para los subarreglos

            //ordenar el lado izquierdo 
            quickSort(arr, low, pivot-1);
            //ordenar el lado derecho
            quickSort(arr, pivot+1, high);

        }
    }



    private int partition(int[] arr, int low, int high){
        int pivot= arr[high];//seleccion del pivote (ultimo elemento)
        int i = low-1;//Esstablece la frontera de los elementos mejores que el pivote

        for(int j=low; j<high; j++){
            if(arr[j]<pivot){
                i++;//incrementa la frontera de los menores
                swap(arr, i, j);//realiza el intercsambio del elemneto corriente a la primera posicion de la frontera
            }

        }

        //mover el pivote a la posicion final de la frontera 
        swap(arr, i+1, high);
        return i+1;
    }
    
    
    private void swap(int[] arr, int i, int j){//Realiza el cambio de posicion de un arreglo
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

}
