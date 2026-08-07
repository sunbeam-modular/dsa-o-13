import java.util.Arrays;

public class Tester {
	
	public static void quickSort(int arr[], int left, int right) {
		//0. stop if partition has single element or invalid
		if(left >= right)
			return;
		//1. select pivot element
		int pivot = arr[left];
		//2. arrange smaller elements on left of pivot
		//3. arrange greater elements on right of pivot
		int i = left, j = right;
		while(i < j) {	
			// find element greater than pivot from left side
			for( ; i <= right && arr[i] <= pivot ; i++);
			// find element less or equal than pivot from right side
			for( ; arr[j] > pivot ; j--);
			// if i and j are not crossed, then swap ith and jth element
			if(i < j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}// repeat until i and j are crossed
		//if i and j are crossed, then swap jth and pivot element
		int temp = arr[left];
		arr[left] = arr[j];
		arr[j] = temp;		
		//4. sort left and rightt side of pivot individually
		quickSort(arr, left, j-1);
		quickSort(arr, j+1, right);
	}

	public static void main(String[] args) {
		int arr[] = {66, 33, 99, 11, 77, 22, 55, 66, 88};
		
		System.out.println("Array before sort : " + Arrays.toString(arr));
		
		quickSort(arr, 0, arr.length-1);
		
		System.out.println("Array after sort : " + Arrays.toString(arr));

	}

}
