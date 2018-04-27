/**
 * @author johnny
 * 反转单链表
 */
public class Practice1_3_30 {
    private Node first;

    private class Node{
        int item;
        Node next;
    }

    public void add(int item){
        if(first==null){
            first=new Node();
            first.item=item;
            return;
        }
        Node newOne=new Node();
        newOne.item=item;
        Node tail=first;
        while(tail.next!=null){
            tail=tail.next;
        }
        tail.next=newOne;
        return;
    }

    public Node reverse(Node oldFirst){
        if(oldFirst==null){
            System.out.println("空链表");
            return null;
        }

        Node temp=oldFirst;
        Node newFirst=null;

        while (temp!=null){
            Node second=temp.next;
            temp.next=newFirst;
            newFirst=temp;
            temp=second;
        }

        return newFirst;
    }
}
