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
	
	private int findMinKeyVertex(int key[], boolean mst[]) {
		int minKey = INF, minKeyVertex = -1;
		for(int i = 0 ; i < vertexCount ; i++) {
			if(!mst[i] && key[i] < minKey) {
				minKey = key[i];
				minKeyVertex = i;
			}
		}
		return minKeyVertex;
	}
	
	public void primsMST(int start) {
		//0. create array to keep track of mst
		boolean mst[] = new boolean[vertexCount];
		//0. create array to keep track of parents
		int parent[] = new int[vertexCount];
		//0. create array to keep tract of keys
		int key[] = new int[vertexCount];
		//0. create variable to maintain count of vertices in mst
		int count = 0;
		//0. mark parent as -1 and key as INF for all vertices
		for(int i = 0 ; i < vertexCount ; i++) {
			mst[i] = false;
			parent[i] = -1;
			key[i] = INF;
		}
		//0. make key of start vertex as 0
		key[start] = 0;
		// repeat until all vertices are added into mst
		while(count < vertexCount) {
			//1. find minimum key vertex which is not added into mst
			int u = findMinKeyVertex(key, mst);
			//2. add min key vertex into MST and increment the count
			mst[u] = true;
			count++;
			//3. update key and parent of adjacent vertices of u which are not added into mst
			for(int v = 0 ;  v < vertexCount ; v++) {
				if(!mst[v] && adjMatrix[u][v] != INF && adjMatrix[u][v] < key[v]) {
					key[v] = adjMatrix[u][v];
					parent[v] = u;
				}
			}
		}
		
		// print mst and find it's weight
		int wt = 0;
		System.out.print("MST : ");
		for(int i = 0 ; i < vertexCount ; i++) {
			System.out.print("(" + parent[i] + "," + i + ")");
			wt += key[i];
		}
		System.out.println("\nweight = " + wt);
	}
	
}


















