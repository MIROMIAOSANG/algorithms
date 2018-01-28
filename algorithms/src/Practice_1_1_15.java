/**
 * Algorithms 4th 1.1.15
 * @date 20180127
 * @author johnnylee
 *
 */
public class Practice_1_1_15 {
	public static int[] histogram(int a[],int M){
		int[] r=new int[M];
		int count=0;
		for(int i=0;i<M;i++	){
			for(int j=0;j<a.length;j++){
				if(i==a[j]){
					count++;
				}
			}
			r[i]=count;
		}
		return r;
	}
	public static void main(String[] args) {
	}

}
