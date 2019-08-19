package com.tree;

import com.tree.traversal.Inorder;

public class BuildTreeFrom2TypeTraversal {

	public static void main(String[] args) {
		Node root = buildTree(new int[] { 4, 2, 5, 1, 6, 3 }, new int[] { 1, 2, 4, 5, 3, 6 }, 0, 5);
		Inorder.traverse(root);
	}

	static int preIndex = 0;

	private static Node buildTree(int[] inOrder, int[] prePrder, int startIdx, int endIdx) {

		if (startIdx > endIdx) {
			return null;
		}
		Node node = new Node(prePrder[preIndex++]);
		if (startIdx == endIdx) {
			return node;
		}

		int idx = search(inOrder, node.getValue());
		node.setLeft(buildTree(inOrder, prePrder, startIdx, idx - 1));
		node.setRight(buildTree(inOrder, prePrder, idx + 1, endIdx));
		return node;

	}

	private static int search(int[] inOrder, int value) {

		for (int i = 0; i < inOrder.length; i++) {
			if (inOrder[i] == value) {
				return i;
			}
		}
		return -1;
	}

}
