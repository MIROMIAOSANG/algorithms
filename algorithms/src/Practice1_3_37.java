
/**
 * Algorithms 4th 1.3.37 Josephus
 * 
 * @date 20180127
 * @author johnnylee
 * 
 */
public class Practice1_3_37 {
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		int M = Integer.parseInt(args[1]);
		LinkedQueueOfStrings<Integer> queue = new LinkedQueueOfStrings<Integer>();
		for (int i = 0; i < N; i++) {
			queue.enqueue(i);
		}
		while (!queue.isEmpty()) {
			for (int i = 0; i < M - 1; i++) {
				queue.enqueue(queue.dequeue());
			}
			System.out.print(queue.dequeue() + " ");
		}
		System.out.println();
	}

}
