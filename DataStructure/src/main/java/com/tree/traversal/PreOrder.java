package com.tree.traversal;

import com.tree.Node;

/**
 * Root left Right
 * 
 * @author Ratan
 *
 */
public class PreOrder {

	public static void traverse(Node node) {
		if (node == null) {
			return;
		}
		System.out.println(node.getValue());
		traverse(node.getLeft());
		traverse(node.getRight());

	}
}
