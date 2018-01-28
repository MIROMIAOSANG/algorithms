import java.util.Iterator;

/**
 * linked list stack(generic
 * 
 * @date 20180119
 * @author johnnylee
 * 
 */
public class LinkedStackOfStrings<Item> implements Iterable<Item> {
	private Node first;
	private int N;

	private class Node {
		Item item;
		Node next;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void push(Item item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
	}

	public Item pop() {
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}

	public int size() {
		return N;
	}

	public static void main(String args[]) {
		LinkedStackOfStrings<String> stack = new LinkedStackOfStrings<String>();
		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			if (s.equals("-")) {
				StdOut.print(stack.pop());
			} else {
				stack.push(s);
			}
		}
	}

	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item> {
		private Node current = first;

		public boolean hasNext() {
			return current != null;
		}

		public void remove() {
		}

		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
}
