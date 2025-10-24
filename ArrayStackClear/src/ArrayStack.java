public class ArrayStack<T> implements IStack<T> {
 private Object[] data;
 private int top;

 //constructor 1
    public ArrayStack() {
        this(10);//invoca al constructor 2
    }

    public ArrayStack(int initialCapacity) {//constructor 2
        this.data = new Object[initialCapacity];
        this.top = 0;
    }

    @Override
    public void push(T element) {
        //nos vamos a asegurar que aun tenga espacio el array
        data[top++]=(T)element;
    }

    @Override
    public T pop() {
        if(isEmpty()){
            System.out.println("La fila esta vacia ");
            return null;
        }

        T value = (T) data[--top];
        data[top]= null;
        return value;
    }

    @Override
    public T peek() {
        if(isEmpty()){
            System.out.println("La fila esta vacia ");
            return null;
        }
        return (T) data[top];
    }

    @Override
    public void clear() {
       for (int i = 0; i < top; i++) {
        data[i] = null; 
    }
    top = 0;
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public boolean isEmpty() {
        return top==0;
    }

    @Override
    public void print() {
       StringBuilder sb = new StringBuilder();
       sb.append("[");
       for (int i = top-1; i>=0; i--) {
           sb.append(data[i]);
           if(i!=0){
            sb.append("->");//separador mientras sea diferente de cero
           }
       }
       sb.append("]");
       System.out.println(sb.toString());
    }

  
}
