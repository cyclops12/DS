package com.tree.traversal;

import com.tree.Node;

public class Traversal {

	public static void main(String[] args) {
		Node tree = constructTree();
		System.out.println("In-Order");
		Inorder.traverse(tree);
		System.out.println("Pre-Order");
		PreOrder.traverse(tree);
		System.out.println("Post-Order");
		PostOrder.traverse(tree);
	}

	private static Node constructTree() {

		Node root = new Node(1);
		root.setLeft(new Node(2));
		root.setRight(new Node(3));
		root.getLeft().setLeft(new Node(4));
		root.getLeft().setRight(new Node(5));
		return root;

	}

}
