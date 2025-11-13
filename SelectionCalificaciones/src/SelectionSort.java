public class SelectionSort {

    public void sort(String[] nombres,int[]calificaciones){
        int n= calificaciones.length;
        for(int i= 0; i<n-1;i++){
            int minIndex=i; //seleccionamos el primero como el menor 
            for(int j= i+1;j<n;j++){//Iniciamos desde la parte no ordenada 
                if(calificaciones[j]<calificaciones[minIndex]){
                    minIndex=j; //indice del menor dentro de la parte ordenada 
                }
            }
            //Intercambio de posicion (pasa el menor a la posicion indicada de la parte ordenada)
            int tempcalif=calificaciones[minIndex];
            calificaciones[minIndex]=calificaciones[i];
            calificaciones[i]=tempcalif;

            String tempNombre = nombres[minIndex];
            nombres[minIndex] = nombres[i];
            nombres[i] = tempNombre;
        }
        System.out.println("\nDatos ordenados");
        for (int i = 0; i < n; i++) {
            System.out.println(nombres[i] + " : " + calificaciones[i]);
        }
    }
}