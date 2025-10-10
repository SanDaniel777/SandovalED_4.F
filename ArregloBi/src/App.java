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
            for(int j=0;j<arriBiD[i].length;j++){
                System.out.println(arriBiD[i][j]);
            }
            System.out.println();
        }
        //Copiar un arreglo
        int[] a = {1,2,3,4};
        int[] b = new int[4];
        
        for(int i =0; i<a.length;i++){
            b[i]=a[i];
        }
        //otros metodos
        //System.arraycopy(a,0,b,0,4);
        //int[]c=Array.copyOf(a,5);
        //System.out.println(Arrays.toString(c));

        System.out.println(Arrays.toString(b));

        System.out.print("---------------------------------------------");
        System.out.println("Aqui empiezan los ejercicios");

    }
}
