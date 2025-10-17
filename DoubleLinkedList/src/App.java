public class App {
    public static void main(String[] args) throws Exception{
        
        DoubleLinkedList list = new DoubleLinkedList();
        list.printFoward();
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(6);
        list.printFoward();
        System.out.println("----------Imprimir pa tras-------");
        list.printBackward();
    }
}
