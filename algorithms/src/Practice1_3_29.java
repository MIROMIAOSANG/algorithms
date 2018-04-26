/**
 * @author johnny
 * 练习1.3.29 循环队列
 */
public class Practice1_3_29<Item> {
    private Node last;

    private class Node<Item> {
        Item item;
        Node next;
    }

    public void enqueue(Item item) {
        if (last == null) {
            last = new Node();
            last.item = item;
            return;
        }

        Node first = new Node();
        first.item = item;
        first.next = last.next;
        last.next = first;

        if (first.next == null) {
            first.next = last;
        }
        return;
    }

    public Item dequeue() {
        Item item;
        if (last.next == null || last.next == last) {
            item = (Item) last.item;
            last = null;
            return item;
        }
        Node first = last.next;
        last.next = first.next;
        return (Item) first.item;
    }

    public boolean isEmpty(){
        return last==null;
    }

    public static void main(String[] args) {
        Practice1_3_29<Integer> test=new Practice1_3_29<Integer>();
        for (int i=0;i<10;i++){
            test.enqueue(i);
        }

        while (!test.isEmpty()){
            System.out.println(test.dequeue());
        }

    }
}
