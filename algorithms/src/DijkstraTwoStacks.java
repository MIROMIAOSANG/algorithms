import java.util.Stack;

public class DijkstraTwoStacks {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<Double> val = new Stack<>();
        while (!StdIn.isEmpty()) {
            //读取表达式
            String s = StdIn.readString();
            if (s.equals("(")) {

            }
            if (s.equals("+")) {
                ops.push(s);
            } else if (s.equals("-")) {
                ops.push(s);
            } else if (s.equals("*")) {
                ops.push(s);
            } else if (s.equals("/")) {
                ops.push(s);
            } else if (s.equals(")")) {
                //遇到右括号，取出一个操作数和一个操作符进行运算
                String c = ops.pop();
                double v = val.pop();
                if (c.equals("+")) {
                    v = v + val.pop();
                } else if (c.equals("-")) {
                    v = v - val.pop();
                } else if (c.equals("*")) {
                    v = v * val.pop();
                } else if (c.equals("/")) {
                    v = v / val.pop();
                }
                val.push(v);
            } else {
                //遇到操作数则将其入栈
                val.push(Double.parseDouble(s));
            }
        }
        StdOut.println(val.pop());
    }
}
