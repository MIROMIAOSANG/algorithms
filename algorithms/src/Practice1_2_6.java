/**
 * ALgorithms 4th 1.2.6
 * @date 20180127
 * @author johnnylee
 *
 */
public class Practice1_2_6 {
	public static void main(String[] args) {
		String s=StdIn.readLine();
		String t=StdIn.readLine();
		if(s.length()==t.length()&&s.concat(s).indexOf(t)>=0){
			System.out.println("yes");
		}
	}

}
