import java.util.Arrays;

class Heap{
	private int[] arr;
	private int SIZE;
	
	public Heap(int arr[]) {
		this.arr = arr;
		this.SIZE = arr.length-1;
	}
	
	public void heapify() {
		// start from first non leaf node (parent) from right side
		for(int i = SIZE / 2 ; i >= 1 ; i--) {
			// take backup of ith element (parent) into temp variable
			int temp = arr[i];
			// find appropriate place for parent
			int ci = i * 2;
			while(ci <= SIZE) {
				// find index of maximum child
				if((ci + 1) <= SIZE && arr[ci + 1] > arr[ci])
					ci = ci + 1;
				// if parent is already maximum than max child
				if(temp > arr[ci])
					break;
				// if child is greater promote it to parent place
				arr[ci/2] = arr[ci];
				// update child index
				ci = ci * 2;
			}
			// put parent on its appropriate place
			arr[ci / 2] = temp;
		}
	}
	
	public int deleteHeap() {
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
}

public class HeapSortMain {
	
	public static void heapSort(int[] arr) {
		Heap h = new Heap(arr);
		//1. convert array into heap
		h.heapify();
		//2. delete all elements from the heap and keep them from right side
		for(int i = arr.length-1 ; i >= 1 ; i--)
			arr[i] = h.deleteHeap();
	}

	public static void main(String[] args) {
		int arr[] = {0, 25, 10, 20, 15, 50, 30, 40, 60, 100};
		
		System.out.println("Array before sort : " + Arrays.toString(arr));
		
		heapSort(arr);
		
		System.out.println("Array after sort : " + Arrays.toString(arr));

	}

}
