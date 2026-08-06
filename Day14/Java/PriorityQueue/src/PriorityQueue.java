
public class PriorityQueue {
	Heap h;
	
	public PriorityQueue(int size) {
		h = new Heap(size);
	}
	
	public void offer(int value) {
		h.addHeap(value);
	}
	
	public int poll() {
		return h.deleteHeap();
	}
	
	public int peek() {
		if(isEmpty())
			return -1;
		return h.getRoot();
	}
	
	public boolean isEmpty() {
		return h.isEmpty();
	}
	
	public boolean isFull() {
		return h.isFull();
	}
}






