import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {

        //Declaracion de iniciacion
        int [][] arriBiA= new int[4][4];
        //Declaracion
        int [][] arriBiB;
        //Inicializacion
        arriBiB=new int[4][4];
        System.out.println(arriBiA[0][0]);
        //Acceso
        arriBiA[0][3]=10;

        //Imprimir
        for(int i=0; i<arriBiB.length; i ++){
            for (int j = 0; j<arriBiB.length; j++) {
                System.out.println(arriBiB[i][j]);
            }
            System.out.println();
        }
        System.out.println(arriBiB[0][3]);
        //Declaramos literal
        int[][] arriBiC={
            {1,2,3,4},
            {1,2,3,4},
            {1,2,3,4},
            {1,2,3,4},
        };

        //Imprimir por for each
        for(int[]fila:arriBiC){
            for(int valor : fila){
                System.out.println(valor);
            }
            System.out.println();
        }
        System.out.println(Arrays.deepToString(arriBiC));


        //Arreglo irregular(jagged)
        int[][] arriBiD={
            {1,2,3},
            {1,2,3,4,5},
            {1},
            {2,2,2,2,2,2}
        };
        for(int i=0;i<arriBiD.length;i++){
            for(int j=0;j<arriBiD.length;j++){
                System.out.println(arriBiD[i][j]);
            }
            System.out.println();
        }

    }
}
