package gs;

public class SearchATree {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		tree.inorder();
		boolean ans=tree.searchKey(40);
		System.out.println(ans);

	}

}

class BinaryTree {
	Node root;

	BinaryTree() {
		root = null;
	}

	public void insert(int data) {
		root = insertNode(root, data);
	}

	private Node insertNode(Node root, int key) {
		if (root == null) {
			root = new Node(key);
			return root;
		}
		if (root.data < key) {
			root.left = insertNode(root.left, key);
		} else if (root.data > key) {
			root.right = insertNode(root.right, key);
		}
		return root;
	}

	void inorder() {
		inorderRec(root);
	}

	void inorderRec(Node root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.println(root.data);
			inorderRec(root.right);
		}
	}
	
	public boolean searchKey(int data) {
		//System.out.println("sss"+root);
	Node nd	=contains(root,data);
	System.out.println("absc"+nd);
	if(nd.data == data)
		return true;
		else
	 return false;
	}
	public Node contains(Node root,int key) {
		if(root== null || root.data == key)
			return root;
		
		 if(root.data>key)
			return contains(root.left, key);
		
			return contains(root.right, key);
			
		
	}
}

class Node {
	int data;
	Node left, right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}
