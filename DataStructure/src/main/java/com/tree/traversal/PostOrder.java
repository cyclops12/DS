package com.tree.traversal;

import com.tree.Node;

/**
 * Left Right Root
 * 
 * @author Ratan
 *
 */
public class PostOrder {

	public static void traverse(Node node) {
		if (node == null) {
			return;
		}
		traverse(node.getLeft());
		traverse(node.getRight());
		System.out.println(node.getValue());
	}
}
