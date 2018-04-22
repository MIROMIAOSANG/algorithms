import java.util.Stack;

/**
 * @author johnny
 */
public class Practice1_3_10 {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("(")) {

            } else if (s.equals("+")
                    || s.equals("-")
                    || s.equals("*")
                    || s.equals("/")) {
                ops.push(s);
            } else if (s.equals(")")) {
                StdOut.print(ops.pop() + " ");
            } else {
                StdOut.print(s + " ");
            }
        }
        StdOut.println();
    }
}
