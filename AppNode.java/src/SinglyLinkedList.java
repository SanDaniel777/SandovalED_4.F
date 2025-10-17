public class SinglyLinkedList {
    
    Node head;
    
    public void add(int data){
        Node newNode = new Node(data);//Crear nuevo nodo
        if(head == null){//Verificar la lista vacia
            head=newNode;
            return;
        }

        Node current=head;

        while(current.next!=null){ //Recoremos los nodos
            current=current.next;
        }
        current.next=newNode; //Insertamos nuevo nodo al final de la lista

    }

    public boolean contains(int data){
        
        Node current=head;
        while(current!=null){
            if(current.data == data){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void remove(int data){
        if(head==null){//Preguntar si lista esta vacia
            return;
        }
        if(head.data == data){//Valida que el dato este en el head
            head=head.next;
            return;
        }

        Node current=head;
        while(current.next!=null && current.next.data!= data){//Recorer hasta encontrar el valor
            current = current.next;   
        }

        current.next=current.next.next; //Asignamos el nodo corriente al siguiente

    }

    public void printList(){
        Node current=head;
        while(current!=null){
            System.out.println(current.data);
            current=current.next;

        }
        System.out.println("null");
    }

   public boolean contar(int data) {
    Node current = head;
    boolean encontrado = false;
    int contador = 0;

    while (current != null) {
        if (current.data == data) {
            contador++;
            System.out.println("Dato repetido encontrado: " + current.data);
            encontrado = true;
        }
        current = current.next;
    }

    if (encontrado) {
        System.out.println("El dato " + data + " se repite " + contador + " veces en la lista.");
    } else {
        System.out.println("El dato " + data + " no se encontró en la lista.");
    }

    return encontrado;
    }
}
