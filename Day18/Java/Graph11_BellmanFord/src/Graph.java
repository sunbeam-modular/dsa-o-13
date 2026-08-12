import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Graph {
	static class Edge{
		private int src, dest;
		private int wt;
		
		public Edge(int s, int d, int w) {
			src = s;
			dest = d;
			wt = w;
		}
	}
	
	private final int INF = 999;
	private int vertexCount, edgeCount;
	private int adjMatrix[][];
	private List<Edge> edges;
	
	public Graph(int vCount) {
		vertexCount = vCount;
		adjMatrix = new int[vertexCount][vertexCount];
		for(int i = 0 ; i < vertexCount ; i++)
			for(int j = 0 ; j < vertexCount ; j++)
				adjMatrix[i][j] = INF;
		edges = new ArrayList<Graph.Edge>();
	}
	
	public void acceptGraph(Scanner sc) {
		System.out.print("Enter edge count : ");
		edgeCount = sc.nextInt();
		for(int i = 0 ; i < edgeCount ; i++) {
			int src = sc.nextInt();
			int dest = sc.nextInt();
			int wt = sc.nextInt();
			adjMatrix[src][dest] = wt;
			//adjMatrix[dest][src] = wt;	// comment this line for directed graph
			edges.add(new Edge(src, dest, wt));
		}	
	}
	
	public void printGraph() {
		System.out.println("Vertex count : " + vertexCount);
		System.out.println("Edge count : " + edgeCount);
		System.out.println("Grght : ");
		for(int i = 0 ; i < vertexCount ; i++) {
			for(int j =  0 ; j < vertexCount ; j++) {
				System.out.print("\t" + (adjMatrix[i][j] == INF ? "INF" : adjMatrix[i][j]));
			}
			System.out.println("");
		}
	}
	
	public void bellmanFord(int start) {
		//0. create array of distances
		int dist[] = new int[vertexCount];
		Arrays.fill(dist, INF);
		dist[start]  = 0;
		//1. for V-1 times update distances
		for(int i = 1 ; i < vertexCount ; i++) {
			for(Edge e : edges) {
				if(dist[e.src] != INF && dist[e.src] + e.wt < dist[e.dest])
					dist[e.dest] = dist[e.src] + e.wt;
			}
		}
		
		//2. check for -ve edge cycle
		for(Edge e : edges) {
			if(dist[e.src] != INF && dist[e.src] + e.wt < dist[e.dest]) {
				System.out.println("Graph has -ve edge cycle");
				return;
			}
		}
		//3. print distance array
		for(int i = 0 ; i < vertexCount ; i++)
			System.out.println(start + "->" + i + " : " + dist[i]);
	}
}











