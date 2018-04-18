import java.util.Iterator;

public class ArrayStack<T> implements Iterable<T>{
    private T[] stack;
    private int top;

    public ArrayStack(int capacity) {
        stack = (T[]) new Object[capacity];
        top = 0;
    }

    public void push(T value) {
        if (top == stack.length) {
            resize(2 * top);
        }
        stack[top++] = value;
    }

    public T pop() {
        T temp=stack[--top];
        stack[top]=null;
        if(top>0 &&top==stack.length/4){
            resize(stack.length/2);
        }
        return temp;
    }

    public int size() {
        return top;
    }

    public void resize(int max) {
        T[] a = (T[]) new Object[max];
        for (int i = 0; i < top; i++) {
            a[i] = stack[i];
        }
        stack = a;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorInstance();
    }

    private class IteratorInstance implements Iterator<T>{
        private int i=top;
        @Override
        public boolean hasNext() {
            return i>0;
        }

        @Override
        public T next() {
            return stack[--i];
        }
    }

    public static void main(String[] args) {
        ArrayStack<String> stack=new ArrayStack<>(10);
        stack.push("li");
        stack.push("ding");
        stack.push("kai");

        for (String s:stack){
            StdOut.println(s);
        }


    }
}
