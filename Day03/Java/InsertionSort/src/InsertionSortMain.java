import java.util.Arrays;

public class InsertionSortMain {
	
	public static void insertionSort(int arr[], int N) {
		//1. pick array elements one by one
		for(int i = 1 ; i < N ; i++) {
			int temp = arr[i];
			//2. compare left neighbors one by one 
			int j;
			for(j = i - 1 ; j >= 0 ; j--) {
				//3. if left neighbor is greater than picked element, move it one place ahead
				if(arr[j] > temp)
					arr[j+1] = arr[j];
				else
					break;
			}
			//4. insert picked element at its appropriate position
			arr[j+1] = temp;
		}
	}

	public static void main(String[] args) {
		int arr[] = {50, 40, 20, 60, 10, 30};
		
		System.out.println("Before sort : " + Arrays.toString(arr));

		insertionSort(arr, arr.length);
		
		System.out.println("After sort : " + Arrays.toString(arr));
	}

}
