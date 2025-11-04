public class ArrayStack<T> implements IStack<T> {
    private Object[] data;
    private int top;

    // Constructor por defecto
    public ArrayStack() {
        this(10); // capacidad inicial 10
    }

    // Constructor con capacidad personalizada
    public ArrayStack(int initialCapacity) {
        this.data = new Object[initialCapacity];
        this.top = 0;
    }

    @Override
    public void push(T element) {
        if (top == data.length) {
            System.out.println("La pila está llena");
            return;
        }
        data[top++] = element;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            System.out.println("La pila está vacía");
            return null;
        }
        @SuppressWarnings("unchecked")
        T value = (T) data[--top];
        data[top] = null;
        return value;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            System.out.println("La pila está vacía");
            return null;
        }
        @SuppressWarnings("unchecked")
        T value = (T) data[top - 1];
        return value;
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
        return top == 0;
    }

    @Override
    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = top - 1; i >= 0; i--) {
            sb.append(data[i]);
            if (i != 0) sb.append(" -> ");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    //Metodo palindromo
    public static boolean isPalindrome(String text) {
        String clean = text.replaceAll("[^a-zA-Z]", "").toLowerCase();
        ArrayStack<Character> stack = new ArrayStack<>(clean.length());

        for (int i = 0; i < clean.length(); i++) {
            stack.push(clean.charAt(i));
        }

        for (int i = 0; i < clean.length(); i++) {
            char c = stack.pop();
            if (c != clean.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}