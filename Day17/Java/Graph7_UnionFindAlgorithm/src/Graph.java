import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Graph {
	static class Edge{
		private int src, dest;
		
		public Edge(int s, int d) {
			src = s;
			dest = d;
		}
	}
	
	private int vertexCount, edgeCount;
	private boolean adjMatrix[][];
	private List<Edge> edges;
	
	public Graph(int vCount) {
		vertexCount = vCount;
		adjMatrix = new boolean[vertexCount][vertexCount];
		edges = new ArrayList<Graph.Edge>();
	}
	
	public void acceptGraph(Scanner sc) {
		System.out.print("Enter edge count : ");
		edgeCount = sc.nextInt();
		for(int i = 0 ; i < edgeCount ; i++) {
			int src = sc.nextInt();
			int dest = sc.nextInt();
			adjMatrix[src][dest] = true;
			adjMatrix[dest][src] = true;	// comment this line for directed graph
			edges.add(new Edge(src, dest));
		}	
	}
	
	public void printGraph() {
		System.out.println("Vertex count : " + vertexCount);
		System.out.println("Edge count : " + edgeCount);
		System.out.println("Grght : ");
		for(int i = 0 ; i < vertexCount ; i++) {
			for(int j =  0 ; j < vertexCount ; j++) {
				System.out.print("\t" + (adjMatrix[i][j] ? "1" : "0"));
			}
			System.out.println("");
		}
		
	}
	
	private int find(int parent[], int v) {
		while(parent[v] != -1)
			v = parent[v];
		return v;
	}
	
	private void union(int parent[], int srcRoot, int destRoot) {
		parent[srcRoot] = destRoot;
	}
	
	// union find algorithm
	public boolean hasCycle() {
		int parent[] = new int[vertexCount];
		Arrays.fill(parent, -1);
		for( Edge e : edges) {
			// find root of src
			int srcRoot = find(parent, e.src);
			// find root of dest
			int destRoot = find(parent, e.dest);
			// if both are same cycle is detected
			if(srcRoot == destRoot)
				return true;
			//if both are different, merge both the sets
			union(parent, srcRoot, destRoot);	
		}
		return false;
	}
}











