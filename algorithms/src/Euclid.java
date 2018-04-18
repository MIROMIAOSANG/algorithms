public class Euclid {
    public static int divisor(int a,int b){
        if(b==0){
            return a;
        }
        int c=a%b;
        return divisor(b,c);
    }

    public static void main(String[] args) {
        System.out.println(Euclid.divisor(15,5));
    }
}
