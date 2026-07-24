
public class Stack {
	private int arr[];
	private final int SIZE;
	private int top;
	
	public Stack(int size) {
		SIZE = size;
		arr = new int[SIZE];
		top = -1;
	}
	
	public void push(int value) {
		// check if full
		if(isFull())
			System.out.println("Stack is full");
		else {
			//1. reposition top
			top++;
			//2. add value at top index
			arr[top] = value;
			
			// arr[++top] = value;
		}
	}
	
	public int pop() {
		int val = -1;
		// check for empty
		if(isEmpty())
			System.out.println("Stack is empty");
		else {
			val = arr[top];
			//1. reposition top
			top--;
		}
		return val;
	}
	
	public int peek() {
		int val = -1;
		// check for empty
		if(isEmpty())
			System.out.println("Stack is empty");
		else {
			//1. read value from top end
			val = arr[top];
		}
		return val;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == SIZE - 1;
	}
}










