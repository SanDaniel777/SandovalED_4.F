import java.util.Stack;

public class ArrayQueue<T> {
    private Object[] data;
    private int front;
    private int rear;
    private int size;

    public ArrayQueue(int capacity) {
        data = new Object[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    public void enqueue(T element) {
        if (size == data.length) {
            throw new IllegalStateException("Queue is full");
        }
        data[rear] = element;
        rear = (rear + 1) % data.length;
        size++;
    }

     @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T element = (T) data[front];
        front = (front + 1) % data.length;
        size--;
        return element;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

   
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[(front + i) % data.length]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public void reverse() {
        Stack<T> stack = new Stack<>();
        while (!isEmpty()) {
            stack.push(dequeue());
        }
        while (!stack.isEmpty()) {
            enqueue(stack.pop());
        }


    }

}
