package JavaDemo;

import java.util.Arrays;

/**
 * Testing how to use the eight types of data
 */
public class NumberDemo {

  private static double N = 5;

  private void testNaN() {
    //isNaN判断是不是数
    System.out.println(Double.isNaN(N));
  }

  public static void main(String[] args) {
    //isNaN
    NumberDemo nd = new NumberDemo();
    nd.testNaN();

    //2.0-1.1不得0.9,因为浮点数使用二进制表示
    System.out.println(2.0 - 1.1);

    //与0的运算,得到一个无穷
    double m=1.0;
    System.out.println(m/0);

    //int不能转换为char,但char能转换为int
    System.out.println((int)('A'));

    //Math类常用方法
    System.out.println(Math.round(9.9));
    System.out.println(Math.sin(Math.PI/2));
    System.out.println(Math.log10(1000));

    //String类常用方法
    String s="miaosang";
    String b="miao";
    String h="miro";
    String v="MIRO";
    String a="abcd";
    System.out.println(s.substring(1,4));
    System.out.println(s.substring(3));
    System.out.println(String.join("/","S","M","L"));
    System.out.println(s.equals(h));
    System.out.println(h.equalsIgnoreCase(v));
    System.out.println(s.compareTo(h));
    System.out.println(a.charAt(0));
    System.out.println(s.indexOf(b));
    System.out.println(h.toUpperCase().equals(v));

    //StringBuilder类的常用方法(单线程,StringBuffer适合多线程)
    StringBuilder builder=new StringBuilder();
    builder.append(h);
    builder.append(s);
    System.out.println(builder.toString());

    //Arrays类常用方法
    int[] array=new int[10];
    int[] ss={4,3,2,1};
    System.out.println(Arrays.toString(array));
    Arrays.fill(array,1);
    System.out.println(Arrays.toString(array));
    Arrays.sort(ss);
    System.out.println(Arrays.toString(ss));
  }
}
