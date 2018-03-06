import java.util.Iterator;

/**
 * @date 20180306
 *
 * using genetics to finish array of stack
 * it can resize the stack automatically
 */
public class GenericsArrayOfStack<Item> implements Iterable<Item>{
  private Item[] stack;
  private int size;

  public GenericsArrayOfStack(int cap){
    stack=(Item[])new Object[cap];
    size=0;
  }

  public boolean isEmpty(){
    return size==0;
  }

  public int size(){
    return size;
  }

  public void push(Item item){
    if(size==stack.length){
      resize(2*stack.length);
    }
    stack[size++]=item;
  }

  public Item pop(){
    Item item=stack[--size];
    //避免对象游离（丢失）
    stack[size]=null;
    if(size==stack.length/4&&size>0){
      resize(stack.length/2);
    }
    return item;
  }

  /**
   * to resize the array
   *
   * @param length is the new array's length
   */
  private void resize(int length){
    Item[] temp=(Item[])new Object[length];
    for(int i=0;i<stack.length;i++){
      temp[i]=stack[i];
    }
    stack=temp;
  }

  private class ReverseArrayIterator implements Iterator<Item> {

    private int i = size;

    public boolean hasNext() {
      return i > 0;
    }

    public Item next() {
      return stack[--i];
    }

    public void remove() {
    }
  }

  public Iterator<Item> iterator(){
    return new ReverseArrayIterator();
  }
}

class GenericsArrayOfStackTest{

  public static void main(String[] args) {
    GenericsArrayOfStack<Integer> stack=new GenericsArrayOfStack<>(10);
    stack.push(1);
    System.out.println(stack.isEmpty());
    stack.push(2);
    System.out.println(stack.size());
    System.out.println(stack.pop());
  }
}
