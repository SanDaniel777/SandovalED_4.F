public class SinglyLinkedList {

    Node head;

    public void add(int data){
        Node newNode=new Node(data);//creacion de un nuevo nodo
        if(head==null){//verificacion de la lista vacia  
            head=newNode;
            return;
        }
        Node current=head;
        while(current.next!=null){//recorrido de los nodos , hasta encontrar  el ultimo  
            current=current.next;
        }
        current.next = newNode; //Insertar un nuevo nodo al final de la lista 
    }

    public boolean contains(int data){




        Node current=head;
        while(current!=null){
            if(current.data==data){
                return true;
            }
            current=current.next;

        }
        return false;
    }

    public void remove(int data){
        if(head==null){//preguntar si la lsta esta  vacia 
            return;
        }
        if(head.data==data){//validar que el dato este en head 
            return;
        }

        Node current = head;
        while(current.next!=null && current.next.data!=data){//recorrer hasta encontrar el valor 
            current=current.next;
        }
        current.next=current.next.next;//asignamos el nodo corriente al otro 
    
    }

    public void printList(){
        Node current = head;
        while(current!=null){
            System.out.println(current.data);
            current=current.next;

        }
        System.out.println("null");
    }

}
