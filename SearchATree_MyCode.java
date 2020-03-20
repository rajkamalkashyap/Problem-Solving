package gs;

import java.util.ArrayList;
import java.util.List;

public class SearchATree_MyCode {

	public static void main(String[] args) {
		BST searchTree = new BST();
		searchTree.put(3);
		searchTree.put(1);
		searchTree.put(2);
		searchTree.put(5);
		List<Integer> ans = searchTree.inOrderTraversal();
		System.out.println(ans);
		boolean isthere = searchTree.contains(7);
		System.out.println(isthere);
	}

}

class BST {

	private Node root;

	public BST() {
		this.root = new Node();
	}

	public void put(int value) {
		insertNode(value, root);
	}

	private void insertNode(int value, Node node) {
		if (node.val == null) {
			node.val = value;
		} else {
			if (value < node.val) {
				if (node.left == null) {
					node.left = new Node();
				}
				insertNode(value, node.left);
			} else {
				if (node.right == null) {
					node.right = new Node();
				}
				insertNode(value, node.right);
			}
		}
	}

	public boolean contains(int value) {
		return contains(value, root);
	}

	private boolean contains(int value, Node node) {
		if (node == null || node.val == null) {
			return false;
		} else {
			if (value == node.val) {
				return true;
			} else if (value < node.val) {
				return contains(value, node.left);
			} else {
				return contains(value, node.right);
			}
		}
	}

	public List<Integer> inOrderTraversal() {
		final ArrayList<Integer> acc = new ArrayList<>();
		inOrderTraversal(root, acc);
		return acc;
	}

	private void inOrderTraversal(Node node, List<Integer> acc) {
		if (node == null) {
			return;
		}
		inOrderTraversal(node.left, acc);
		inOrderTraversal(node.right, acc);
		acc.add(node.val);
	}

	private static class Node {
		Integer val;
		Node left;
		Node right;

	}
}
