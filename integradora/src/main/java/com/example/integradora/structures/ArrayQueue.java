package com.example.integradora.structures;

public class ArrayQueue<T> implements IQueue<T> {

    private Object[] data;
    private int rear;
    private int front;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    public ArrayQueue() {
        this.data = new Object[INITIAL_CAPACITY];
    }

    @Override
    public void offer(T element) {
        expandCapacity();
        data[rear] = element;
        rear = (rear + 1) % data.length;
        size++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T poll() {
        if (isEmpty()) {
            System.out.println("La cola está vacía.");
            return null;
        }
        T result = (T) data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return result;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            System.out.println("La cola está vacía.");
            return null;
        }
        return (T) data[front];
    }

    @Override
    public void clear() {
        data = new Object[INITIAL_CAPACITY];
        front = 0;
        size = 0;
        rear = 0;
    }

    @Override
    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[(front + i) % data.length]);
            if (i < size - 1) sb.append(" => ");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    private void expandCapacity() {
        if (size == data.length) {
            Object[] newArr = new Object[data.length * 2];
            for (int i = 0; i < size; i++) {
                newArr[i] = data[(front + i) % data.length];
            }
            front = 0;
            data = newArr;
            rear = size;
        }
    }

    public Object[] toArray() {
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = data[(front + i) % data.length];
        }
        return result;
    }

    public boolean remove(Object element) {
        if (isEmpty()) return false;

        int indexToRemove = -1;
        for (int i = 0; i < size; i++) {
            int currIndex = (front + i) % data.length;
            if (data[currIndex].equals(element)) { 
                indexToRemove = i; 
                break;
            }
        }

        if (indexToRemove == -1) return false; 

        Object[] newArr = new Object[data.length];
        int newSize = 0;
        
        for (int i = 0; i < size; i++) {
            if (i == indexToRemove) continue; 
            newArr[newSize++] = data[(front + i) % data.length];
        }

        this.data = newArr;
        this.front = 0;
        this.size = newSize;
        this.rear = newSize;
        
        return true;
    }


}
