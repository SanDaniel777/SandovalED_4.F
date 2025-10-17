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


}
