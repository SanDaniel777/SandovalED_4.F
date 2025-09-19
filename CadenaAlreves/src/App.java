public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Kevin Daniel");
        String og = "Hola";
        System.out.println(og.charAt(0));
        reverseWord(og.length()-1,og);
    }

    public static void reverseWord(int index, String og){
        if (index == 0) {
            System.out.print(og.charAt(0));
            return;
        }
        System.out.print(og.charAt(index)+"");
        reverseWord(index-1, og);
    }

}
