public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Kevin Daniel Sandoval!");
           int n=5;
             
            System.out.println(" los primeros numeros de la serie fibonacci " +n+ " son:");
            for(int i = 0; i < n; i++){
                System.out.println("Fibo:" +i+ + fibonacci(i));
            }
        
        



    }
    
    static int fibonacci(int n){
            if (n <= 1) return n;
            return fibonacci(n -1)+fibonacci(n-2);
        }

    }
