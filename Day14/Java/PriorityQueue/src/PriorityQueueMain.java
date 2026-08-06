
public class PriorityQueueMain {

	public static void main(String[] args) {
		
		PriorityQueue q = new PriorityQueue(9);
		
		q.offer(20);
		q.offer(12);
		q.offer(35);
		q.offer(15);
		q.offer(10);
		q.offer(80);
		
		System.out.println("Peeked element = " + q.peek());

		while(!q.isEmpty())
			System.out.println("Popped element = " + q.poll());
	}

}
