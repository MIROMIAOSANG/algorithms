import java.util.Iterator;

/**
 * array of stack(generic and the changed array)
 *
 * @author johnnylee
 * @version 20180124
 */
public class FixedCapacityStackOfStrings<Item> implements Iterable<Item>{
    private Item[] s;
    private int N = 0;

    @SuppressWarnings("unchecked")
    public FixedCapacityStackOfStrings(int capacity) {
        s = (Item[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(Item item) {
        if (N == s.length) {
            resize(2 * s.length);
        }
        s[N++] = item;
    }

    public Item pop() {
        Item item = s[--N];
        s[N] = null;
        if (N == s.length / 4 && N > 0) {
            resize(s.length / 2);
        }
        return item;
    }

    public int size() {
        return N;
    }

    /**
     * change the array
     *
     * @param Max
     */
    @SuppressWarnings("unchecked")
    public void resize(int Max) {
        Item[] item = (Item[]) new Object[Max];
        for (int i = 0; i < N; i++) {
            item[i] = s[i];
        }
        s = item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    /**
     * iterator method
     *
     * @author johnnylee
     */
    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = N;


        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return s[--i];
        }

        @Override
        public void remove() {
        }
    }

}
