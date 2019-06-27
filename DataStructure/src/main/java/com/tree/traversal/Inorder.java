package com.tree.traversal;

/**
 * Left Root Right
 * @author Ratan
 *
 */
public class Inorder {
	
	public static void traverse(Node node) {
		if(node == null) {
			return;
		}
		traverse(node.getLeft());
		System.out.println(node.getValue());
		traverse(node.getRight());
	}

}
