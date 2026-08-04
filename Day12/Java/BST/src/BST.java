import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST {
	
	static class Node{
		private int data;
		private Node left;
		private Node right;
				
		public Node(int value) {
			data = value;
			left = right = null;
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
		if(root == null)
			root = new Node(value);
		else
			addNodeRec(root, value);
	}
	
	private void addNodeRec(Node trav, int value) {
		if(value < trav.data) {
			if(trav.left == null) {
				trav.left = new Node(value);
				return;
			}else {
				addNodeRec(trav.left, value);
			}
		}else {
			if(trav.right == null) {
				trav.right = new Node(value);
				return;
			}else {
				addNodeRec(trav.right, value);
			}
		}
	}
	
	private void preOrder(Node trav) {		// original method
		// if tree is empty, return
		if(trav == null)
			return;
		System.out.print(" " + trav.data);	//	Visit
		preOrder(trav.left);				//	Left
		preOrder(trav.right);				//	Right			
	}
	
	public void preOrder() {				// wrapper method
		System.out.print("Preorder : ");
		preOrder(root);
		System.out.println("");
	}
	
	private void inOrder(Node trav) {		// original method
		// if tree is empty, return
		if(trav == null)
			return;
		inOrder(trav.left);				//	Left
		System.out.print(" " + trav.data);	//	Visit
		inOrder(trav.right);				//	Right			
	}
	
	public void inOrder() {				// wrapper method
		System.out.print("Inorder : ");
		inOrder(root);
		System.out.println("");
	}
	
	private void postOrder(Node trav) {		// original method
		// if tree is empty, return
		if(trav == null)
			return;
		postOrder(trav.left);				//	Left
		postOrder(trav.right);				//	Right	
		System.out.print(" " + trav.data);	//	Visit
	}
	
	public void postOrder() {				// wrapper method
		System.out.print("Postorder : ");
		postOrder(root);
		System.out.println("");
	}
	
	public Node binarySearch(int key) {
		//1. create trav and start at root
		Node trav = root;
		while(trav != null) {
			//2. if key is matching with current node
			if(key == trav.data)
				return trav;
			//3. if key is less than current node
			if(key < trav.data)
				trav = trav.left;
			//4. if key is greater than current node
			else
				trav = trav.right;
		}//5. repeat step 2 to 4 till leaf node
		//6. if key is not found
		return null;
	}
	
	private Node binarySearchRec(Node trav, int key) {
		//1. stop if tree is empty
		if(trav == null)
			return null;
		//2. if key is matching with current node
		if(key == trav.data)
			return trav;
		//3. if key is less than current node
		if(key < trav.data)
			return binarySearchRec(trav.left, key);
		//4. if key is greater than current node
		else
			return binarySearchRec(trav.right, key);
	}
	
	public Node binarySearchRec(int key) {
		return binarySearchRec(root, key);
	}
	
	public void deleteNode(int key) {
		//1. search for a node with its parent
		Node trav = root, parent = null;
		while(trav != null) {
			if(key == trav.data)
				break;
			parent = trav;
			if(key < trav.data)
				trav = trav.left;
			else
				trav = trav.right;
		}
		//2. if node is not found
		if(trav == null)
			return;
		//3. if node is found
		//3.1 node has 2 child
		if(trav.left != null && trav.right != null) {
			//1. find predecessor
			Node pred = trav.left;
			parent = trav;
			while(pred.right != null) {
				parent = pred;
				pred = pred.right;
			}
			//2. replace node by predecessor
			trav.data = pred.data;
			//3. delete predecessor
			if(pred == parent.left)
				parent.left = pred.left;
			else if(pred == parent.right)
				parent.right = pred.left;
		}
		//3.2 node has single left child
		else if(trav.right == null) {
			if(trav == root)
				root = trav.left;
			else if(trav == parent.left)
				parent.left = trav.left;
			else if(trav == parent.right)
				parent.right = trav.left;
		}
		//3.3. node has single right child
		else {	//if(trav.left == null) {
			if(trav == root)
				root = trav.right;
			else if(trav == parent.left)
				parent.left = trav.right;
			else if(trav == parent.right)
				parent.right = trav.right;
		}
	}
	
	public void DFSTraversal() {
		//0. create stack to push nodes
		Stack<Node> st = new Stack<BST.Node>();
		//1. push root on stack
		st.push(root);
		System.out.print("DFS Traversal : ");
		//repeat untill stack is empty
		while(!st.isEmpty()) {
			//2. pop node from stack
			Node trav = st.pop();
			//3. visit node
			System.out.print(" " + trav.data);
			//4. if right exist push it on stack
			if(trav.right != null)
				st.push(trav.right);
			//5. if left exist push it on stack
			if(trav.left != null)
				st.push(trav.left);
		}
		System.out.println("");
	}

	public void BFSTraversal() {
		//0. create queue to push nodes
		Queue<Node> q = new LinkedList<>();
		//1. push root on queue
		q.offer(root);
		System.out.print("BFS Traversal : ");
		//repeat untill queue is empty
		while(!q.isEmpty()) {
			//2. pop node from queue
			Node trav = q.poll();
			//3. visit node
			System.out.print(" " + trav.data);
			//4. if left exist push it on queue
			if(trav.left != null)
				q.offer(trav.left);
			//5. if right exist push it on queue
			if(trav.right != null)
				q.offer(trav.right);
		}
		System.out.println("");
	}
	
	public void deleteAll() {
		root = null;
	}
}












