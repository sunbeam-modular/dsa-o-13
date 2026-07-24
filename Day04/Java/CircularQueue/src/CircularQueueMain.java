import java.util.Scanner;

public class CircularQueueMain {

	public static void main(String[] args) {
		CircularQueue que = new CircularQueue(5);
		
		Scanner sc = new Scanner(System.in);
		int choice;
		
		do {
			System.out.println("0. Exit\n1. Offer\n2. Poll\n3. Peek");
			System.out.print("Enter your choice : ");
			choice = sc.nextInt();
			
			switch(choice)
			{
			case 1:
				System.out.print("Enter value to be inserted : ");
				int val = sc.nextInt();
				que.offer(val);
				break;
			case 2:
				System.out.println("Removed value : " + que.poll());
				break;
			case 3:
				System.out.println("Peeked value : " + que.peek());
				break;
			}
		}while(choice != 0);
		
		
		sc.close();


	}

}
