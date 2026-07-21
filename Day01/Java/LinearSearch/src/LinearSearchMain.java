import java.util.Scanner;

public class LinearSearchMain {
	
	public static int linearSeach(int[] arr, int key) {
		//2. traverse array from start to end
		for(int i = 0 ; i < arr.length ; i++) {
			//3. compare key with array element
			if(key == arr[i])
				return i;
		}
		//4. key is not found
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = {88, 33, 66, 99, 11, 77, 22, 55, 44};
		
		Scanner sc = new Scanner(System.in);
		//1. take key from user
		System.out.print("Enter key to be searched : ");
		int key = sc.nextInt();
		
		int index = linearSeach(arr, key);
		if(index != -1)
			System.out.println("Key is found at index " + index);
		else
			System.out.println("Key is not found");
		sc.close();

	}

}
