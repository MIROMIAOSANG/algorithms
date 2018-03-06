import java.util.Iterator;

/**
 * @date 20180306
 *
 * using linkedlist to finish stack
 */
public class LinkedlistOfStack<Item> implements Iterable<Item> {

  private int size;
  private Node first;

  private class Node {

    Item item;
    Node next;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public int size() {
    return size;
  }

  public void push(Item item) {
    Node old = first;
    first = new Node();
    first.item = item;
    first.next = old;
    size++;
  }

  public Item pop() {
    Item item = first.item;
    first = first.next;
    size--;
    return item;
  }

  public Iterator<Item> iterator() {
    return new ReverseStack();
  }

  private class ReverseStack implements Iterator<Item> {

    private Node pointer = first;

    public boolean hasNext() {
      return pointer != null;
    }

    public Item next() {
      Item item = pointer.item;
      pointer = pointer.next;
      return item;
    }

    public void remove() {
    }
  }
}
