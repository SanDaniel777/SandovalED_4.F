public class DoubleLinkedList {

Node head;

public void add(int data){
    Node newNode= new Node(data);
if(head==null){
    head=newNode;
    return;
}
Node current = head;
while(current.next!=null){
    current=current.next;
}
current.next=newNode;
newNode.prev=current;
}

public void printFoward(){
    Node current=head;
    while(current!=null){
        System.out.println(current.data);
        current=current.next;
    }
    System.out.println(current);
}

public void printBackward(){
    Node current = head;
    while(current.next!=null){
        current=current.next;
    }
    while(current!=null){
        System.out.println(current.data);
        current=current.prev;
    }
    System.out.println(current);
}

public void remove(int data) {
        if (head == null) {
            System.out.println("Lista vacía");
            return;
        }

        Node current = head;
        while (current != null && current.data != data) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Valor no encontrado");
            return;
        }

        
        if (current == head) {//se elimina si el elemento esta al inicio 
            head = current.next;
            if (head != null) {
                head.prev = null;
            }
        }
        
        else {//se elimina si el elemento esta en otra parte 
            current.prev.next = current.next;
            if (current.next != null) {
                current.next.prev = current.prev;
            }
        }

        System.out.println("Nodo con valor " + data + " eliminado correctamente.");
    }
}