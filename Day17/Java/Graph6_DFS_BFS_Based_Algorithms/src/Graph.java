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
	
	public boolean isConnected(int start) {
		//0. create stack to push and array to mark vertices
		Stack<Integer> st = new Stack<Integer>();
		boolean marked[] = new boolean[vertexCount];
		//1. push start vertex, mark it and start counting from 1
		st.push(start);
		marked[start] = true;
		int count = 1;
		// repeat until stack is empty
		while(!st.isEmpty()) {
			//2.pop vertex from the stack
			int u = st.pop();
			//3. push non marked adjacents of popped vertex on stack, mark them and increment count
			for(int v = 0 ; v < vertexCount ; v++) {
				if(!marked[v] && adjMatrix[u][v]) {
					st.push(v);
					marked[v] = true;
					count++;				
				}
			}
			//4. check if count is equal to vertexCount
			if(count == vertexCount)
				return true;
		}
		//5. if graph is not conncted
		return false;
	}
	
	public boolean isBipartite(int start) {
		//0. create queue to push and array to color the vertices
		Queue<Integer> q = new LinkedList<Integer>();
		int color[] = new int[vertexCount];
		//2. push start vertex on  queue and color it with c1
		q.offer(start);
		color[start] = 1;
		// while queue is not empty repeat
		while(!q.isEmpty()) {
			//3. pop vertex from queue
			int u = q.poll();
			//4. check adjacent of popped vertex
			for(int v = 0 ; v < vertexCount ; v++) {
				if(adjMatrix[u][v]) {
					//5. check if they colored with same color
					if(color[u] == color[v])
						return false;
					//6. if adjacent is not colored, push it on queue and color it with opposite color
					if(color[v] == 0) {
						q.offer(v);
						color[v] = color[u] * -1;
					}
				}
			}
		}
		return true;
	}
	
	public void singleSourcePathLength(int start) {
		//0. create queue to push, array to mark and array to maintain path length of the vertice
		Queue<Integer> q = new LinkedList<Integer>();
		boolean marked[] = new boolean[vertexCount];
		int length[] = new int[vertexCount];
		//1. push start vertex on queue, mark it and update length as 0
		q.offer(start);
		marked[start] = true;
		length[start] = 0;
		// repeat till queue is not empty\
		while(!q.isEmpty()) {
			//2. pop vertex from the queue
			int u = q.poll();
			//3. push all non marked adjacent vertices on queue, mark then and update their length
			for(int v = 0 ; v < vertexCount ; v++) {
				if(!marked[v] && adjMatrix[u][v]) {
					q.offer(v);
					marked[v] = true;
					length[v] = length[u] + 1;
				}
			}
		}
		System.out.println("Path length from vertex " + start + " : ");
		for(int i = 0 ; i < vertexCount ; i++)
			System.out.println(i + " : " + length[i]);
	}
	
	public void DFSSpanningTree (int start) {
		//0. create stack to push vertices
		Stack<Integer> st = new Stack<Integer>();
		//0. create an array to mark vertices
		boolean marked[] = new boolean[vertexCount];
		System.out.print("DFS spanning Tree : ");
		//2. push start vertex on stack and mark it
		st.push(start);
		marked[start] = true;
		while(!st.isEmpty()) {
			//3. pop vertex from stack
			int u = st.pop();
			//4. print vertex
			//System.out.print(" " + u);
			//5. push non marked vertices on stack and mark them
			for(int v = 0 ; v < vertexCount ; v++) {
				if(!marked[v] && adjMatrix[u][v]) {
					st.push(v);
					marked[v] = true;
					System.out.print("(" + u + "," + v + ")");
				}
			}
		}//6. repeat step 3-5 untill stack is empty
		System.out.println("");
	}
	
	//1. choose start vertex
	public void BFSpanningTree (int start) {
		//0. create queue to push vertices
		Queue<Integer> q = new LinkedList<Integer>();
		//0. create an array to mark vertices
		boolean marked[] = new boolean[vertexCount];
		System.out.print("BFS Spanning Tree : ");
		//2. push start vertex on queue and mark it
		q.offer(start);			// push
		marked[start] = true;
		while(!q.isEmpty()) {
			//3. pop vertex from queue
			int u = q.poll();			// pop
			//4. print vertex
			//System.out.print(" " + u);
			//5. push non marked vertices on queue and mark them
			for(int v = 0 ; v < vertexCount ; v++) {
				if(!marked[v] && adjMatrix[u][v]) {
					q.offer(v);
					marked[v] = true;
					System.out.print("(" + u + "," + v + ")");
				}
			}
		}//6. repeat step 3-5 untill queue is empty
		System.out.println("");
	}
	
}

















