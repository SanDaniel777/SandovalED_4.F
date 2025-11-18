public class App {
    public static void main(String[] args) throws Exception {
        InsertionSort sorting= new InsertionSort();
        System.out.println("Bienvenido a las temperaturas");

        int[] temp={15,-8,25,34,42,7,9,30};
        System.out.println("Arreglo original:");
        for(int t:temp)System.out.print(t + " ");

        System.out.println("\nTemperaturas Ordenadas: ");
        sorting.sort(temp);

        System.out.println("Temperatura mas baja: "+temp[0]);
        System.out.println("Temperatura mas alta: "+temp[temp.length-1]);

        System.out.println("Las 3 temperaturas mas bajas: ");
        for(int i=0;i<3;i++){
            System.out.print(temp[i]+" ");
        }

        System.out.println("\nLas 3 temperaturas mas altas: ");
        for(int i=temp.length-1;i>=temp.length-3;i--){
            System.out.print(temp[i]+" ");
        }

        int rango = temp[temp.length - 1] - temp[0];
        System.out.println("\nEl rango (máxima - mínima) es: " + rango);

    }
}
