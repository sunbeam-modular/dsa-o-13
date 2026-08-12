import java.util.Scanner;

public class Graph {
	private final int INF = 999;
	private int vertexCount, edgeCount;
	private int adjMatrix[][];
	
	public Graph(int vCount) {
		vertexCount = vCount;
		adjMatrix = new int[vertexCount][vertexCount];
		for(int i = 0 ; i < vertexCount ; i++)
			for(int j = 0 ; j < vertexCount ; j++)
				adjMatrix[i][j] = INF;
	}
	
	public void acceptGraph(Scanner sc) {
		System.out.print("Enter edge count : ");
		edgeCount = sc.nextInt();
		for(int i = 0 ; i < edgeCount ; i++) {
			int src = sc.nextInt();
			int dest = sc.nextInt();
			int wt = sc.nextInt();
			adjMatrix[src][dest] = wt;
			adjMatrix[dest][src] = wt;	// comment this line for directed graph
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
	
	private int findMinDistVertex(int dist[], boolean spt[]) {
		int minDist = INF, minDistVertex = -1;
		for(int i = 0 ; i < vertexCount ; i++) {
			if(!spt[i] && dist[i] < minDist) {
				minDist = dist[i];
				minDistVertex = i;
			}
		}
		return minDistVertex;
	}
	
	public void DijkstrasSPT(int start) {
		//0. create array to keep track of spt
		boolean spt[] = new boolean[vertexCount];
		//0. create array to keep track of parents
		int parent[] = new int[vertexCount];
		//0. create array to keep tract of distances
		int dist[] = new int[vertexCount];
		//0. create variable to maintain count of vertices in spt
		int count = 0;
		//0. mark parent as -1 and dist as INF for all vertices
		for(int i = 0 ; i < vertexCount ; i++) {
			spt[i] = false;
			parent[i] = -1;
			dist[i] = INF;
		}
		//0. make dist of start vertex as 0
		dist[start] = 0;
		// repeat until all vertices are added into spt
		while(count < vertexCount) {
			//1. find minimum dist vertex which is not added into spt
			int u = findMinDistVertex(dist, spt);
			//2. add min dist vertex into SPT and increment the count
			spt[u] = true;
			count++;
			//3. update dist and parent of adjacent vertices of u which are not added into spt
			for(int v = 0 ;  v < vertexCount ; v++) {
				if(!spt[v] && adjMatrix[u][v] != INF && dist[u] + adjMatrix[u][v] < dist[v]) {
					dist[v] = dist[u] + adjMatrix[u][v];
					parent[v] = u;
				}
			}
		}
		
		// print distances of all vertices from start vertex
		for(int i = 0 ; i < vertexCount ; i++) {
			System.out.println(start +  "->" + i + " : " + dist[i]);
		}
	}
	
}


















