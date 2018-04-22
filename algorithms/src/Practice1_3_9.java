import java.util.Stack;

/**
 * @author johnny
 */
public class Practice1_3_9 {
    public static void main(String[] args) {
        Stack<String> ops=new Stack<>();
        Stack<String> val=new Stack<>();
        while (!StdIn.isEmpty()){
            String s= StdIn.readString();
            if(s.equals("(")){

            }
            else if(s.equals("+")
                    ||s.equals("-")
                    ||s.equals("*")
                    ||s.equals("/")){
                ops.push(s);
            }
            else if(s.equals(")")){
                String a=ops.pop();
                String b=val.pop();
                String v=String.format("( %s %s %s )",val.pop(),a,b);
                val.push(v);
            }
            else{
                val.push(s);
            }
        }

        StdOut.println(val.pop());
    }
}
