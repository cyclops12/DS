package com.tree.traversal;

import com.tree.Node;

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
