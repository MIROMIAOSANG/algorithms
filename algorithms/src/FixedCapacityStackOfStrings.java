import java.util.Iterator;

/**
 * array of stack(generic and the changed array)
 * 
 * @version 20180124
 * @author johnnylee
 * 
 */
public class FixedCapacityStackOfStrings<Item> {
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

	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}

	/**
	 * iterator method
	 * 
	 * @author johnnylee
	 * 
	 */
	private class ReverseArrayIterator implements Iterator<Item> {
		private int i = N;

		public boolean hasNext() {
			return i > 0;
		}

		public Item next() {
			return s[--i];
		}

		public void remove() {
		}
	}

	public static void main(String[] args) {
		FixedCapacityStackOfStrings<String> s;
		s = new FixedCapacityStackOfStrings<>(100);
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-")) {
				s.push(item);
			} else if (!s.isEmpty()) {
				StdOut.print(s.pop() + " ");
			}
		}
		StdOut.println("(" + s.size() + "left on stack)");
	}
}
