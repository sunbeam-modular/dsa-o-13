import java.util.Arrays;

public class Tester {
	public static void mergeSort(int[] arr, int left, int right) {
		//0. stop if partition has single element
		if(left == right)
			return;
		//1. divide array into two parts
		int mid = (left + right) / 2;
		//2. sort both the partitions individually
		mergeSort(arr, left, mid);
		mergeSort(arr, mid + 1, right);
		//3. merge sorted partitions into temp array
		int size = right - left + 1;
		int[] temp = new int[size];
		int i = left, j = mid + 1, k = 0;
		// 3.1 compare ith element and jth element 
		while(i <= mid && j <= right) {
			if(arr[i] < arr[j]) {
				// ith element is small
				temp[k] = arr[i];
				i++;
				k++;
			}else {
				// jth element is small
				temp[k] = arr[j];
				j++;
				k++;
			}
		}
		//3.2 if left partition is finished, add remaining elements of right partition into temp array
		while(j <= right) {
			temp[k] = arr[j];
			j++;
			k++;
		}
		//3.3 if right partition is finished, add remaining elements of left partition into temp array
		while(i <= mid) {
			temp[k] = arr[i];
			i++;
			k++;
		}
		//4. over write temp array into original
		for(i = 0 ; i < size ; i++)
			arr[left + i] = temp[i];
	}

	public static void main(String[] args) {
		int arr[] = {6, 1, 9, 7, 3, 8, 2, 4, 5};
		
		System.out.println("Array before sort : " + Arrays.toString(arr));
		
		mergeSort(arr, 0, arr.length-1);
		
		System.out.println("Array after sort : " + Arrays.toString(arr));

	}

}
