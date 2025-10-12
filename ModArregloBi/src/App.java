public class App {
    public static void main(String[] args) throws Exception {
    
        int[][] arrTest={
            {1},
            {6,3,1},
            {1,2,3,4},
            {0,5,3,0},
            {2,5,9},
            {2,4,8,9,10}
        };
        
        for (int i = 0; i < arrTest.length; i++) {
            int[] fila = arrTest[i];
            int[] nuevaFila = new int[fila.length + 1];

            for (int j = 0; j < fila.length; j++) {
                nuevaFila[j] = fila[j];
            }
            nuevaFila[nuevaFila.length - 1] = fila[fila.length - 1] + 1;
            arrTest[i] = nuevaFila;
        }

        for (int i = 0; i < arrTest.length; i++) {
            for (int j = 0; j < arrTest[i].length; j++) {
                System.out.print(arrTest[i][j] + " ");
            }
            System.out.println();
        }
    }
}
