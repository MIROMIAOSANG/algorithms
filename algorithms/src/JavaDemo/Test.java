package JavaDemo;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        list.add("Lee");
        list.add("DK");
        list.add("nb");
        list.add("123");
        String[] a=new String[3];
        a[0]="DDDK";
        a[1]="111";
        a[2]="222";
        String[] b=list.toArray(a);
        System.out.println(Arrays.toString(b));
        System.out.print(Arrays.toString(a));
    }
}
