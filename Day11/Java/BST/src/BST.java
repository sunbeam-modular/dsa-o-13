import java.util.Stack;

public class BST {
	
	static class Node{
		private int data;
		private Node left;
		private Node right;
		private boolean visited;
		
		public Node(int value) {
			data = value;
			left = right = null;
			visited = false;
		}
	}

	private Node root;
	
	public BST() {
		root = null;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public void addNode(int value) {
		//1. Create a newnode with given value
		Node newnode = new Node(value);
		//2. if BST is empty
		if(root == null)
			// add newnode into root itself
			root = newnode;
		//3. if BST is not empty
		else {
			//3.1 create a reference to traverse BST and start at root
			Node trav = root;
			while(true) {
				//3.2 if value is less than current node data
				if(value < trav.data) {
					//3.2.1 if left of current node is empty
					if(trav.left == null) {
						// add newnode into left of current node
						trav.left = newnode;
						break;
					}
					//3.2.2 if left of current node is not empty
					else
						// traverse on left side
						trav = trav.left;
				}
				//3.3 if value is greater pr equal than current node data
				else {	
					//3.3.1 if right of current node is empty
					if(trav.right == null) {
						// add newnode into right of current node
						trav.right = newnode;
						break;
					}
					//3.3.2 if right of current node is not empty
					else
						// traverse on right side
						trav = trav.right;
				}
			}//3.4 repeat step 3.2 and 3.3 untill node is added into BST
		}
	}
	
	public void preOrder_NonRecursive() {
		//1. create a stack
		Stack<Node> st = new Stack<BST.Node>();
		System.out.print("PreOrder : ");
		//2. start from root node
		Node trav = root;
		while(trav != null || !st.isEmpty()) {
			while(trav != null) {
				//3. visit current node
				System.out.print(" " + trav.data);
				//4. if right exists, then push on stack
				if(trav.right != null)
					st.push(trav.right);
				//5. go on left side
				trav = trav.left;
			}//6. repeate till extreme left	
			//7. pop node from stack to go on right
			if(!st.isEmpty())
				trav = st.pop();
		}//8. repeat untill stack is empty or trav is null
		System.out.println("");
	}
	
	public void inOrder_NonRecursive() {
		//1. create a stack
		Stack<Node> st = new Stack<BST.Node>();
		System.out.print("InOrder : ");
		//2. start from root node
		Node trav = root;
		while(trav != null || !st.isEmpty()) {
			while(trav != null) {
				//3. push current node
				st.push(trav);
				//4. go on left side
				trav = trav.left;
			}//5. repeate till extreme left	
			if(!st.isEmpty()) {
				//6. pop node from stack to go on right
				trav = st.pop();
				//7. visit current node
				System.out.print(" " + trav.data);
				//8. go on right side node
				trav = trav.right;
			}
		}//9. repeat untill stack is empty or trav is null
		System.out.println("");
	}
	
	public void postOrder_NonRecursive() {
		//1. create a stack
		Stack<Node> st = new Stack<BST.Node>();
		System.out.print("PostOrder : ");
		//2. start from root node
		Node trav = root;
		while(trav != null || !st.isEmpty()) {
			while(trav != null) {
				//3. push current node
				st.push(trav);
				//4. go on left side
				trav = trav.left;
			}//5. repeate till extreme left	
			if(!st.isEmpty()) {
				//6. pop node from stack to go on right
				trav = st.pop();
				//7. if right is null or right is visited
				if(trav.right == null || trav.right.visited == true) {
					//8. visit ccurrent node and mark as visited
					System.out.print(" " + trav.data);
					trav.visited = true;
					trav = null;
				}
				//9. if has right but not visited
				else {
					//10. push current node again on stack
					st.push(trav);
					//11. go on right node
					trav = trav.right;
				}
			}
		}//12. repeat step 3 to 11 till stack is not empty or trav is not null
		System.out.println("");
	}
	
	public void deleteAll() {
		root = null;
	}
}












