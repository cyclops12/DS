package com.tree.traversal;

import java.util.Stack;

import com.tree.Node;

public class WithoutRecursion {

	public static void main(String[] args) {
		Node tree = Traversal.constructTree();
		inOrderTraverse(tree);
		System.out.println("-----------------");
		preOrderTraverse(tree);
		System.out.println("-----------------");
		postOrderTraverse(tree);
	}

	private static void inOrderTraverse(Node tree) {
		Stack<Node> stack = new Stack<>();
		Node curr = tree;
		do {
			if (curr != null) {
				stack.push(curr);
				curr = curr.getLeft();
			} else {
				curr = stack.pop();
				System.out.println(curr.getValue());
				curr = curr.getRight();
			}
		} while (curr != null || !stack.isEmpty());
	}

	private static void preOrderTraverse(Node tree) {
		Stack<Node> stack = new Stack<>();
		Node curr = tree;

		while (curr != null || !stack.isEmpty()) {

			if (curr != null) {
				System.out.println(curr.getValue());
				stack.push(curr);
				curr = curr.getLeft();
			} else {
				curr = stack.pop();
				curr = curr.getRight();
			}
		}

	}

	private static void postOrderTraverse(Node tree) {
		Stack<Node> stack = new Stack<>();
		Node curr = tree;

		while (curr != null || !stack.isEmpty()) {

			if (curr != null) {

				stack.push(curr);
				curr = curr.getLeft();
			} else {
				curr = stack.peek();
				if (curr.getRight() != null) {
					curr = curr.getRight();
				} else {
					curr = stack.pop();
					System.out.println(curr.getValue());
					//curr = curr.getRight();
				}
			}
		}

	}

}
