public class App {
    public static void main(String[] args) throws Exception {
        
        int [][] arrBi={
            {1},          
            {6,3,1},       
            {1,2,3,4},     
            {0,5,3,0},    
            {2,5,9},       
            {2,4,8,9,10}
        };

        int[][]arrSalida=new int[arrBi.length][];

        for (int i = 0; i < arrBi.length; i++) {
            int[] fila = arrBi[i];
            int[] nuevaLong = new int[fila.length + 1];
            int[] nuevaFila =nuevaLong;
            

            for (int j = 0; j < fila.length; j++) {
                nuevaFila[j] = fila[j];
            }
            if (fila.length%2==0) {
                int primero = fila[0];
                int ultimo = fila [fila.length-1];
                nuevaFila[nuevaFila.length-1]=primero+ultimo;
            }else{
                nuevaFila[nuevaFila.length-1]=0;
            }
            arrSalida[i] = nuevaFila;
            
        }
         for (int i = 0; i < arrSalida.length; i++) {
            System.out.print("{ ");
            for (int j = 0; j < arrSalida[i].length; j++) {
                System.out.print(arrSalida[i][j]);
                if (j < arrSalida[i].length - 1) System.out.print(",");
            }
            System.out.println(" }");
        }

    }
}
