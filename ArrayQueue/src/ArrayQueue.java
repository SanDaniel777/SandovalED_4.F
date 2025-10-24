public class ArrayQueue <T> implements IQueue<Object>{

    private Object[] data;
    private int rear;//indice de insercion
    private int front;//indica al elemento enfrente del queue
    private int size; //numeros de elementos del queue
    private static final int INITIAL_CAPACITY=10; // constante para el tamano inicial

    public ArrayQueue(){
        this.data= new Object[INITIAL_CAPACITY];
        this.rear=0;
        this.front=0;
        this.size=0;
    }

    @Override
    public void offer(Object element) {
        //verificar la capacidad del array 
        expendCapacity();
        data[rear]=element;//pone el elemento en el indice asignado (rear)
        rear=(rear+1)%data.length;//recalcula rear evitando desvordes
        size++;
    }

    @Override
    public Object poll() {
        if(isEmpty()){
            System.out.println("Esta vacia");
            return null;
        }
        T result= (T)data [front];
        data[front]=null;
        front=(front+1)%data.length;
        size--;
        return result;
    }

    @Override
    public Object peek() {
        if(isEmpty()){
            System.out.println("Esta vacia");
            return null;
        }
        return data[front];
    }

    @Override
    public void clear() {
        
    }

    @Override
    public void print() {
       StringBuilder sb= new StringBuilder();
       sb.append("[");
       for(int i = 0; i<size;i++){
        sb.append(data[(front+i)%data.length]);
        if(i<size-1) sb.append("->");
       }
       sb.append("]");
       System.out.println(sb.toString());
    }

    @Override
    public boolean isEmpty() {
      return size==0;
    }

    @Override
    public int getSize() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSize'");
    }

    private void expendCapacity(){
        Object[] newArr= new Object[data.length*2];//creacion de un nuevo arreglo
        for(int  i = 0; i<size;i++){
            newArr[i]= data[(front+i)%data.length];////vaciado de info comenzando de nuevo
        }
        //reiniciamos los valores de los arreglos para poder seguir usandolo
        front=0;//pone enfrente en la primera poscicion
        data=newArr;//asigna el nuevo arreglo al atributo data
        rear=size;//indice de la siguiente insercion

    }
   

}
