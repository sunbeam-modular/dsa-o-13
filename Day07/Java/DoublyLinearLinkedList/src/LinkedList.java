
public class LinkedList {
	
	static class Node{
		private char data;
		private Node next;
		private Node prev;
		
		public Node(char value) {
			data = value;
			next = prev =  null;
		}
	}
	
	private Node head;
	private Node tail;
	private int size;
		
	public LinkedList() {
		head = tail = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return head == null;
		//return head == null && tail == null;
		//return size == 0;
	}
	
	public int size() {
		return size;
	}
	
	public void addFirst(char value) {
		//1. create a newnode
		Node newnode = new Node(value);
		//2. if list is empty
		if(head == null)
			//a. add newnode into head and tail itself
			head = tail = newnode;
		//3. if list is not empty
		else {
			//a. add first node into next of newnode
			newnode.next = head;
			//b. add newnode into prev of first node
			head.prev = newnode;
			//c. move head on newnode
			head = newnode;
		}
		// increment size
		size++;
	}
	
	public void addLast(char value) {
		//1. create a newnode
		Node newnode = new Node(value);
		//2. if list is empty
		if(head == null)
			//a. add newnode into head and tail itself
			head = tail = newnode;
		//3. if list is not empty
		else {
			//a. add last node into prev of newnode
			newnode.prev = tail;
			//b. add newnode into next of last node
			tail.next = newnode;
			//c. move tail on newnode
			tail = newnode;
		}
		// increment size
		size++;
	}
	
	
	public void addPosition(char value, int pos) {
		//1. create a newnode
		Node newnode = new Node(value);
		//2. if list is empty
		if(head == null)
			// add newnode into head and tail itself
			head = tail = newnode;
		// special cases
		else if(pos <= 1) {
			//a. add first node into next of newnode
			newnode.next = head;
			//b. add newnode into prev of first node
			head.prev = newnode;
			//c. move head on newnode
			head = newnode;
		}
		else if(pos >=  size + 1) {
			//a. add last node into prev of newnode
			newnode.prev = tail;
			//b. add newnode into next of last node
			tail.next = newnode;
			//c. move tail on newnode
			tail = newnode;
		}
		//3. if list is not empty
		else {
			//a. traverse till pos - 1 node
			Node trav = head;
			for(int i = 1 ; i < pos - 1 ; i++)
				trav = trav.next;
			//b. add pos node into next of newnode
			newnode.next = trav.next;
			//c. add pos - 1 node into prev of newnode
			newnode.prev = trav;
			//d. add newnode into prev of pos node
			trav.next.prev = newnode;
			//e. add newnode into next of pos-1 node
			trav.next = newnode;
		}
		// increment size
		size++;
	}
	
	public void deleteFirst() {
		//1. if list is empty
		if(head == null)
			return;
		//2. if list has single node
		else if(head == tail)
			head = tail = null;
		//3. if list has multiple nodes
		else {
			//a. move head on second node
			head = head.next;
			//b. add null into prev of second node
			head.prev = null;
		}
		// decrement size
		size--;
	}
	
	public void deleteLast() {
		//1. if list is empty
		if(head == null)
			return;
		//2. if list has single node
		else if(head == tail)
			head = tail = null;
		//3. if list has multiple nodes
		else {
			//a. move tail on second last node
			tail = tail.prev;
			//b. add null into next of second last node
			tail.next = null;
		}
		// decrement size
		size--;
	}
	
	public void deletePosition(int pos) {
		//0. validate position(1 >= pos <= size)
		if(pos < 1 || pos > size)
			return;
		//1. if list is empty
		if(head == null)
			return;
		// special cases
		else if(pos == 1) {
			//a. move head on second node
			head = head.next;
			//b. add null into prev of second node
			head.prev = null;
		}
		else if(pos == size) {
			//a. move tail on second last node
			tail = tail.prev;
			//b. add null into next of second last node
			tail.next = null;
		}
		//2. if list is not empty
		else {
			//a. traverse till pos node
			Node trav = head;
			for(int i = 1 ; i < pos ; i++)
				trav = trav.next;
			//b. add pos - 1 node into prev of pos + 1 node
			trav.next.prev = trav.prev;
			//c. add pos + 1 node into next of pos - 1 node
			trav.prev.next = trav.next;
		}
		// decrement size
		size--;
	}
	
	public void forwardDisplay() {
		//1. create trav and start on first node
		Node trav = head;
		System.out.print("Forward List : ");
		while(trav != null) {
			//2. print current node
			System.out.print(" " + trav.data);
			//3. go on next node
			trav = trav.next;
		}//4. repeat step 2 and 3 till last node
		System.out.println("");
	}
	
	public void backwardDisplay() {
		//1. create trav and start on last node
		Node trav = tail;
		System.out.print("Backward List : ");
		while(trav != null) {
			//2. print current node
			System.out.print(" " + trav.data);
			//3. go on prev node
			trav = trav.prev;
		}//4. repeat step 2 and 3 till first node
		System.out.println("");
	}
	
	public void deleteAll() {
		head = tail = null;
		size = 0;
	}
}
















