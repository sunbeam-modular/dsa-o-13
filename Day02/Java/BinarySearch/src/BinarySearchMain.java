import java.util.Scanner;

public class BinarySearchMain {
	
	public static int binarySeach(int[] arr, int key) {
		int left = 0, right = arr.length - 1, mid;
		while(left <= right) {
			//2. find middle element of array
			mid = (left + right) / 2;
			//3. compare key with middle element
			//3.1 if key is matching
			if(key == arr[mid])
				return mid;
			//3.2 if key is less than middle elemnt
			else if(key < arr[mid])
				right = mid - 1;
			//3.3 if key is greater than middle element
			else
				left = mid + 1;
		}//4. repeat stem 2 and 3 till valid partition
		//5. if key is not found
		return -1;
	}
	
	public static int binarySearch(int arr[], int key, int left, int right) {
		//0. base condition - stop if partition is invalid (left > right)
		if(left > right)
			return -1;
		//1. find middle element of the array
		int mid = (left + right) / 2;
		//2. compare key with middle element, if matching return
		if(key == arr[mid])
			return mid;
		//3. if key is less than middle element then search it into left partition
		if(key < arr[mid])
			return binarySearch(arr, key, left, mid - 1);
		//4. if key is greater than middle element then search it into right partition
		else
			return binarySearch(arr, key, mid + 1, right);
	}

	public static void main(String[] args) {
		int arr[] = {11, 22, 33, 44, 55, 66, 77, 88, 99};
		
		Scanner sc = new Scanner(System.in);
		//1. take key from user
		System.out.print("Enter key to be searched : ");
		int key = sc.nextInt();
		
		//int index = binarySeach(arr, key);
		int index = binarySearch(arr, key, 0, arr.length-1);
		if(index != -1)
			System.out.println("Key is found at index " + index);
		else
			System.out.println("Key is not found");
		sc.close();

	}

}
