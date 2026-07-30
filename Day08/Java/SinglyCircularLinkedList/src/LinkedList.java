
public class LinkedList {

	static class Node{
		private int data;
		private Node next;
		
		public Node(int value) {
			data = value;
			next = null;
		}
	}
	
	private Node head;
	private Node tail;
	
	public LinkedList() {
		head = tail = null;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void addFirst(int value) {
		//1. create a newnode
		Node newnode = new Node(value);
		//2. if list is empty
		if(head == null) {
			//a. add newnode into head and tail
			head = tail = newnode;
			//b. make list circular
			newnode.next = newnode;
		}
		//3. if list is not empty
		else {
			//a. add first node into next of newnode
			newnode.next = head;
			//b. add newnode into next of last node
			tail.next = newnode;
			//c. move head on newnode
			head = newnode;
		}
	}
	
	public void addLast(int value) {
		//1. create a newnode
		Node newnode = new Node(value);
		//2. if list is empty
		if(head == null) {
			//a. add newnode into head and tail
			head = tail = newnode;
			//b. make list circular
			newnode.next = newnode;
		}
		//3. if list is not empty
		else {
			//a. add first node into next of newnode
			newnode.next = head;
			//b. add newnode into next of last node
			tail.next = newnode;
			//c. move tail on newnode
			tail = newnode;
		}
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
			//b. update next of last node
			tail.next = head;
		}
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
			//a. traverse till second last node
			Node trav = head;
			while(trav.next != tail)
				trav = trav.next;
			//b. move tail on second last node
			tail = trav;
			//c. update next of second last node by head
			trav.next = head;
		}
	}
	
	public void display() {
		//0. if list is empty, return
		if(head == null)
			return;
		//1. create trav and start at head
		Node trav = head;
		System.out.print("List : ");
		do {
			//2. print current node
			System.out.print(" " + trav.data);
			//3. go on next node
			trav = trav.next;
		}while(trav != head);//4. repeat step 2 and 3 till last node
		System.out.println("");
	}
	
	public void deleteAll() {
		head = tail = null;
	}
}












