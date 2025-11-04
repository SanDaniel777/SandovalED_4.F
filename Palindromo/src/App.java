public class App {
    public static void main(String[] args) throws Exception {
         String[] textos = {
            "Anita lava la tina",
            "Hola",
            "La ruta natural",
            "radar",
            "somos o no somos",
            "pepe problemas"
        };

        for (String t : textos) {
            boolean resultado = ArrayStack.isPalindrome(t);
            System.out.println("\"" + t + "\" -> " + resultado);
        }
    }
}
