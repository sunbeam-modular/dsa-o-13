import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Graph {
	
	static class Adjacent{
		private int vertex;
		private int weight;
		
		public Adjacent(int v, int w) {
			vertex = v;
			weight = w;
		}
	}
	
	private int vertexCount, edgeCount;
	private List<Adjacent> adjList[];
	
	public Graph(int vCount) {
		vertexCount = vCount;
		adjList = new List[vertexCount];
		for(int i = 0 ; i < vertexCount ; i++)
			adjList[i] = new ArrayList<Adjacent>();
	}
	
	public void acceptGraph(Scanner sc) {
		System.out.print("Enter edge count : ");
		edgeCount = sc.nextInt();
		for(int i = 0 ; i < edgeCount ; i++) {
			int src = sc.nextInt();
			int dest = sc.nextInt();
			int wt = sc.nextInt();
			adjList[src].add(new Adjacent(dest, wt));
			adjList[dest].add(new Adjacent(src, wt));	// comment this line for directed graph
		}	
	}
	
	public void printGraph() {
		System.out.println("Vertex count : " + vertexCount);
		System.out.println("Edge count : " + edgeCount);
		System.out.println("Grght : ");
		for(int i = 0 ; i < vertexCount ; i++) {
			System.out.print(i + " :");
			for(Adjacent j : adjList[i]){
				System.out.print("\t" + j.vertex + "(" + j.weight + ")");
			}
			System.out.println("");
		}
		
	}
}











