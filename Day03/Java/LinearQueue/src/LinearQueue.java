
public class LinearQueue {
	private int arr[];
	private final int SIZE;
	private int front, rear;
	
	public LinearQueue(int size) {
		SIZE = size;
		arr = new int[SIZE];
		front = rear = -1;
	}

	public void offer(int value) {
		// check if queue is full
		if(rear == SIZE - 1)
			System.out.println("Queue is full");
		else {
			//1. reposition rear
			rear++;
			//2. add value at rear index
			arr[rear] = value;
		}
	}
	
	public int poll() {
		int val = -1;
		// check if queue is empty
		if(front == rear)
			System.out.println("Queue is empty");
		else {
			val = arr[front + 1];
			//1. increment front
			front++;
		}
		return val;
	}
	
	public int peek() {
		int val = -1;
		// check if queue is empty
		if(front == rear)
			System.out.println("Queue is empty");
		else {
			//1. read value of front end
			val = arr[front + 1];
		}
		return val;
	}
	
	public boolean isEmpty() {
		return front == rear;
	}
	
	public boolean isFull() {
		return rear == SIZE - 1;
	}
}
















