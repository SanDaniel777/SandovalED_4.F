public class SinglyLinkedList {

    Node head;

    public void add(int data){
        Node newNode = new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        Node current = head;
        while(current.next!=null){
            current=current.next;
        }
        current.next=newNode;
    }

    public void printFoward(){
        Node current = head;
        while(current!=null){
            System.out.println(current.data);
            current=current.next;
        }
        System.out.println(current);
    }

    public void removeDuplicates(){
        Node current = head;
        while(current!=null){
            Node runner = current.next;
            Node prev = current;
            while(runner!=null){
                if(runner.data==current.data){
                    prev.next=runner.next;
                }else{
                    prev=runner;
                }
                runner=runner.next;
            }
            current=current.next;
        }
    }

    
}
