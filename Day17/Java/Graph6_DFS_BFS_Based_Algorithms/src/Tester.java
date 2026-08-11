import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter vertex count : ");
		int vCount = sc.nextInt();		
		Graph g = new Graph(vCount);
		
		g.acceptGraph(sc);
		//g.printGraph();
		/*
		boolean ret = g.isConnected(1);
		if(ret)
			System.out.println("Graph is conncted");
		else
			System.out.println("Graph is not connected");
		*/
		/*
		boolean ret = g.isBipartite(1);
		if(ret)
			System.out.println("Graph is bipartite");
		else
			System.out.println("Graph is not bipartite");
		*/
		
		//g.singleSourcePathLength(2);
		
		g.DFSSpanningTree(1);
		g.BFSpanningTree(1);
		
		
		
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
1 2
4 3
3 5

6
5
0 3
0 4
1 5
2 3
2 4
2 5



 */











