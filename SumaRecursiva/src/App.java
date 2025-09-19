import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hola kevin, Agrega el numero que quieras sumar");

        
        int n = sc.nextInt();
        int resultado = suma(n);
        System.out.println("La suma de los primeros " +n+ "naturales es:" +resultado);
        sc.close();
    }

    static int suma(int n){
        if (n == 0) {
            return 0;
        }
        return n + suma(n-1);
    }
}
