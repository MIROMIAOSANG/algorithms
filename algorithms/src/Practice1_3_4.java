import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Practice1_3_4 {
    public static void main(String[] args) {
        FixedCapacityStackOfStrings<Character> stack=new FixedCapacityStackOfStrings<>(100);
        //标志位
        boolean judge=true;
        try {
            FileInputStream in=new FileInputStream("test.txt");
            while(in.available()>0){
                char a=(char)in.read();
                if (a=='['||a=='{'||a=='('){
                    stack.push(a);
                }
                //如果第一个即为右括号，栈不判空会出错
                else if(!stack.isEmpty()){
                    if(a=='}'){
                        if (stack.pop()!='{'){
                            judge=false;
                            break;
                        }
                    }
                    if(a==']'){
                        if (stack.pop()!='['){
                            judge=false;
                            break;
                        }
                    }
                    if(a==')'){
                        if (stack.pop()!='('){
                            judge=false;
                            break;
                        }
                    }
                }
            }
            if (!stack.isEmpty()){
                judge=false;
            }
            System.out.println(judge);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
