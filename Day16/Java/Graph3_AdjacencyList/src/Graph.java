import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Graph {
	private int vertexCount, edgeCount;
	private List<Integer> adjList[];
	
	public Graph(int vCount) {
		vertexCount = vCount;
		adjList = new List[vertexCount];
		for(int i = 0 ; i < vertexCount ; i++)
			adjList[i] = new ArrayList<Integer>();
	}
	
	public void acceptGraph(Scanner sc) {
		System.out.print("Enter edge count : ");
		edgeCount = sc.nextInt();
		for(int i = 0 ; i < edgeCount ; i++) {
			int src = sc.nextInt();
			int dest = sc.nextInt();
			adjList[src].add(dest);
			adjList[dest].add(src);	// comment this line for directed graph
		}	
	}
	
	public void printGraph() {
		System.out.println("Vertex count : " + vertexCount);
		System.out.println("Edge count : " + edgeCount);
		System.out.println("Grght : ");
		for(int i = 0 ; i < vertexCount ; i++) {
			System.out.print(i + " :");
			for(Integer j : adjList[i]){
				System.out.print("\t" + j);
			}
			System.out.println("");
		}
		
	}
}











