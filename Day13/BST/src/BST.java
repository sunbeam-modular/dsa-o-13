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
	
		
	public int height(Node trav) {
		//1. if tree is empty/null then return -1
		if(trav == null)
			return -1;
		//2. find height of left sub tree
		int hl = height(trav.left);
		//3. find height of right sub tree
		int hr = height(trav.right);
		//4. find maximum height
		int max = hl > hr ? hl : hr;
		//5. return max + 1
		return max + 1;	
	}
	
	public int height() {
		return height(root);
	}
	
	public void deleteAll() {
		root = null;
	}
}












