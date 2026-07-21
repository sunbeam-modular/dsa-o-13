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

	public static void main(String[] args) {
		int arr[] = {11, 22, 33, 44, 55, 66, 77, 88, 99};
		
		Scanner sc = new Scanner(System.in);
		//1. take key from user
		System.out.print("Enter key to be searched : ");
		int key = sc.nextInt();
		
		int index = binarySeach(arr, key);
		if(index != -1)
			System.out.println("Key is found at index " + index);
		else
			System.out.println("Key is not found");
		sc.close();

	}

}
