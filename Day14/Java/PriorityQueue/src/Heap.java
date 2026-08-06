
public class Heap {
	private int[] arr;
	private int SIZE;
	
	public Heap(int length) {
		SIZE = 0;
		arr = new int[length + 1];
	}
	
	public void addHeap(int value) {
		//0. check for full
		if(isFull())
			return;
		//1. increase size of heap by one
		SIZE++;
		//2. add new value at first empty index from left side
		arr[SIZE] = value;
		//3. adjust position of newly added value
		int ci = SIZE;
		int pi = ci / 2;
		while(pi > 0) {
			// if parent is already maximum
			if(arr[pi] > arr[ci])
				break;
			// if parent is minimum than value
			int temp = arr[pi];
			arr[pi] = arr[ci];
			arr[ci] = temp;
			// update parent and child index
			ci = pi;
			pi = ci / 2;
		}		
	}
	
	public int deleteHeap() {
		//0. check for empty
		if(isEmpty())
			return -1;
		//1. take backup of root element
		int max = arr[1];
		//2. promote last element of heap at root place
		arr[1] = arr[SIZE];
		//3. decrement size of heap
		SIZE--;
		//4. adjust position of promoted element
		int pi = 1;
		int ci = pi * 2;
		while(ci <= SIZE) {
			// update ci by index of maximum child
			if((ci + 1) <= SIZE && arr[ci + 1] > arr[ci])
				ci = ci + 1;
			// if parent is already maximum than max child
			if(arr[pi] > arr[ci])
				break;
			// if parent is minimum than max child then swap both
			int temp = arr[pi];
			arr[pi] = arr[ci];
			arr[ci] = temp;
			// update parent and child index
			pi = ci;
			ci = pi * 2;
		}
		
		//5.  return maximum / deleted value
		return max;
	}
	
	public boolean isEmpty() {
		return SIZE == 0;
	}
	
	public boolean isFull() {
		return SIZE == arr.length - 1;
	}
	
	public int getRoot() {
		return arr[1];
	}
}
