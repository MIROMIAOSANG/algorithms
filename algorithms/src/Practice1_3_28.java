/**
 * @author johnny
 * 递归求链表最大值
 */
public class Practice1_3_28 {
     private Node first;

    private class Node{
        int key;
        Node next;
    }

    public void addNode(int key){
        if(first==null){
            first=new Node();
            first.key=key;
            return;
        }
        Node tail=first;
        while(tail.next!=null){
            tail=tail.next;
        }
        Node newNode=new Node();
        newNode.key=key;
        tail.next=newNode;
    }

    public int getMax(Node node){
        if(node.next==null){
            return node.key;
        }
        int a=getMax(node.next);
        if(a>=node.key){
            return a;
        }
        else{
            return node.key;
        }
    }

    public static void main(String[] args) {
        Practice1_3_28 test=new Practice1_3_28();
        for(int i=10;i>0;i--){
            test.addNode(i);
        }

        System.out.println(test.getMax(test.first));

    }


}

