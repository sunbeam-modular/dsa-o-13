import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter vertex count : ");
		int vCount = sc.nextInt();		
		Graph g = new Graph(vCount);
		
		g.acceptGraph(sc);
		//g.printGraph();
		
		boolean ret = g.hasCycle();
		if(ret)
			System.out.println("Graph has cycle");
		else
			System.out.println("Graph doesn't have cycle");
		
		sc.close();

	}

}

/*

6
7
0 1
0 2
0 3
1 2
1 4
3 4
3 5


6
5
0 1
0 2
0 3
1 4
3 5



 */











