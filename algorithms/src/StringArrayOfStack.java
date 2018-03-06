/**
 * @date 20180306
 *
 * pratise coding array of stack
 */
public class StringArrayOfStack {
  private String[] stack;
  private int size;
  public StringArrayOfStack(int cap){
    stack=new String[cap];
    size=0;
  }

  public boolean isEmpty(){
    return size==0;
  }

  public int size(){
    return size;
  }

  public void push(String item){
    stack[size++]=item;
  }

  public String pop(){
    return stack[--size];
  }
}

class StringArrayOfStackTest{

  public static void main(String[] args) {
    StringArrayOfStack stack=new StringArrayOfStack(10);
    stack.push("lee");
    System.out.println(stack.isEmpty());
    stack.push("johnny");
    System.out.println(stack.size());
    System.out.println(stack.pop());
  }
}
