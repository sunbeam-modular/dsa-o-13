import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Graph {
	private int vertexCount, edgeCount;
	private boolean adjMatrix[][];
	
	public Graph(int vCount) {
		vertexCount = vCount;
		adjMatrix = new boolean[vertexCount][vertexCount];
	}
	
	public void acceptGraph(Scanner sc) {
		System.out.print("Enter edge count : ");
		edgeCount = sc.nextInt();
		for(int i = 0 ; i < edgeCount ; i++) {
			int src = sc.nextInt();
			int dest = sc.nextInt();
			adjMatrix[src][dest] = true;
			adjMatrix[dest][src] = true;	// comment this line for directed graph
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
	
	public void DFSTraversal(int start) {
		//0. create a stack to push vertices
		Stack<Integer> st = new Stack<Integer>();
		//0. create array of flags to mark vertices
		boolean marked[] = new boolean[vertexCount];
		
		System.out.print("DFS Traversal : ");
		//1. choose a start vertex - start
		//2. push start vertex on stack and mark it
		st.push(start);
		marked[start] = true;
		while(!st.isEmpty()) {
			//3. pop vertex from stack
			int u = st.pop();
			//4. print popped vertex
			System.out.print(" " + u);
			//5. push non marked adjacents on stack and mark them
			for(int v = 0 ;  v < vertexCount ; v++) {
				if(!marked[v] && adjMatrix[u][v]) {
					st.push(v);
					marked[v] = true;
				}
			}
		}//6. repeat step 3 to 5 until stack is empty 
		System.out.println("");
	}
	
	public void BFSTraversal(int start) {
		//0. create a queue to push vertices
		Queue<Integer> q = new LinkedList<Integer>();
		//0. create array of flags to mark vertices
		boolean marked[] = new boolean[vertexCount];
		
		System.out.print("BFS Traversal : ");
		//1. choose a start vertex - start
		//2. push start vertex on queue and mark it
		q.offer(start);
		marked[start] = true;
		while(!q.isEmpty()) {
			//3. pop vertex from queue
			int u = q.poll();
			//4. print popped vertex
			System.out.print(" " + u);
			//5. push non marked adjacents on queue and mark them
			for(int v = 0 ;  v < vertexCount ; v++) {
				if(!marked[v] && adjMatrix[u][v]) {
					q.offer(v);
					marked[v] = true;
				}
			}
		}//6. repeat step 3 to 5 until queue is empty 
		System.out.println("");
	}
}

















