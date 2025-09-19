public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Kevin Daniel");
        String og = "Hola";
        String alreves = "";

        for(int i = og.length()-1; i>=0 ;i--){
            alreves += og.substring(i,i+1);
        }
        System.out.println(alreves);

    }
}
