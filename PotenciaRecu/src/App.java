import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Kevin Daniel");
        Scanner sc = new Scanner(System.in);
        System.out.println("Agrega el primer numero: ");
        int n1 = sc.nextInt();
        System.out.println("Agruega su potencia");
        int p= sc.nextInt();
        int resultado= potencia(n1,p);
        System.out.println("el resultado es igual a:" +resultado);
        sc.close();
    }

    static int potencia(int n1, int p){
         if (p == 0) {
            return 1;
        }
         return n1 * potencia(n1, p - 1);
    }

}
