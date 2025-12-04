public class BinarySearchTree {

    Node root; //raiz de nuestro arbol

    public void insert(int value){
        root=insertRecursive(root, value);
    }

    private Node insertRecursive(Node current, int value){
        //caso base, cuando current sea null, en este punto vamos a cerrar el nodo
        if(current==null){
            return new Node(value);
        }
        //si el valor a insertar es menor que el valor del current
        //Entoces vamos a crear el nodo del lado izquierdo
        if(value< current.value){
            current.left= insertRecursive(current.left, value);
        }else if(value> current.value){
            current.right=insertRecursive(current.right, value);
        }
        
        return current;
    }

    public void printInOrder(){
        System.out.println("---Print en Orden---:");
        printInOrderRecursive(root);
    }

    private  void printInOrderRecursive(Node current){
        if(current!=null){
            //recorrido del lado izquierdo
            printInOrderRecursive(current.left);
            System.out.println(current.value+ " ");
            printInOrderRecursive(current.right);

        }
    }
}
