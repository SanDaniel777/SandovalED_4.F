public class SinglyLinkedList {
Node head;

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public boolean contains(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void remove(int data) {
        if (head == null) {
            return;
        }
        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    //método: dividir en pares e impares
    public void splitEvenOdd() {
        SinglyLinkedList evenList = new SinglyLinkedList();
        SinglyLinkedList oddList = new SinglyLinkedList();

        Node current = head;
        while (current != null) {
            if (current.data % 2 == 0) {
                evenList.add(current.data);
            } else {
                oddList.add(current.data);
            }
            current = current.next;
        }

        System.out.println("Original:");
        this.printList();

        System.out.println("Pares:");
        evenList.printList();

        System.out.println("Impares:");
        oddList.printList();
    }
}
