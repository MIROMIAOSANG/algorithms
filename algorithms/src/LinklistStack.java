public class LinklistStack<T> {
    private Node first=null;

    private class Node{
        private T value;
        private Node next;

    }

    public void push(T value){
        Node node=new Node();
        node.value=value;
        node.next=first;
        first=node;
    }

    public T pop(){
        Node temp=first;
        first=first.next;
        return temp.value;
    }
}
