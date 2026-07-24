
public class CircularQueue {
	private int arr[];
	private final int SIZE;
	private int front, rear;
	
	public CircularQueue(int size) {
		SIZE = size;
		arr = new int[SIZE];
		front = rear = -1;
	}
	
	public void offer(int value) {
		// check for full
		if(isFull())
			System.out.println("Queue is full");
		else {
			//1. reposition rear
			rear = (rear + 1) % SIZE;
			//2. add value at rear index
			arr[rear] = value;
		}
	}
	
	public int poll() {
		int val = -1;
		// check for empty
		if(isEmpty())
			System.out.println("Queue is empty");
		else {
			val = arr[(front + 1) % SIZE];
			//1. reposition front
			front = (front + 1) % SIZE;
			// if queue is empty reposition front and rear back to -1
			if(front == rear)
				front = rear = -1;
		}
		return val;
	}
	
	public int peek() {
		int val = -1;
		// check for empty
		if(isEmpty())
			System.out.println("Queue is empty");
		else {
			//1. read value from front end
			val = arr[(front + 1) % SIZE];
		}
		return val;
	}
	
	public boolean isEmpty() {
		return front == rear && rear == -1;
	}
	
	public boolean isFull() {
		return (front == -1 && rear == SIZE - 1) || (front == rear && rear != -1);
	}
	
}








