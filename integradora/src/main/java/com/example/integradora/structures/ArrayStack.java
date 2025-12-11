package com.example.integradora.structures;

public class ArrayStack<T> implements IStack<T> {

    private Object[] data;
    private int top;

    public ArrayStack() {
        this(10);
    }

    public ArrayStack(int capacidadInicial) {
        this.data = new Object[capacidadInicial];
        this.top = 0;
    }

    @Override
    public void push(T element) {
        if (top == data.length) {
            expandCapacity(); 
        }
        data[top++] = element;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T pop() {
        if (isempty()) {
            System.out.println("La pila está vacía");
            return null;
        }
        T value = (T) data[--top];
        data[top] = null;
        return value;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isempty()) {
            System.out.println("La pila está vacía");
            return null;
        }
        return (T) data[top - 1];
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
    public boolean isempty() {
        return top == 0;
    }

    @Override
    public void print() {
        System.out.print("[");
        for (int i = top - 1; i >= 0; i--) {
            System.out.print(data[i]);
            if (i != 0) System.out.print(" => ");
        }
        System.out.println("]");
    }
    
    private void expandCapacity() {
        Object[] newArr = new Object[data.length * 2];
        System.arraycopy(data, 0, newArr, 0, data.length);
        data = newArr;
    }

    // Método para convertir la Pila a un arreglo (Para que Scalar lo vea como JSON)
    public Object[] toArray() {
        // Creamos un arreglo del tamaño actual exacto
        Object[] result = new Object[top + 1];
        // Copiamos los datos (en orden inverso para ver lo más reciente primero)
        for (int i = 0; i <= top; i++) {
            result[i] = data[top - i]; // LIFO: El último entra primero en la vista
        }
        return result;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}