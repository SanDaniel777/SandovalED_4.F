public class App {
    public static void main(String[] args) throws Exception {
       
        SinglyLinkedList list = new SinglyLinkedList();
        list.printFoward();
        list.add(5);
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(3);
        list.add(9);
        list.printFoward();
        list.removeDuplicates();
        System.out.println("Lista nueva sin duplicados: ");
        list.printFoward();

    }
}
