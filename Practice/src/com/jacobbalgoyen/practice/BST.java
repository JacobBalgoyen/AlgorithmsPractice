package com.jacobbalgoyen.practice;

import java.util.ArrayList;
import java.util.Stack;

public class BST {
	public Node root;
	
	public BST(){
		this.root = new Node();
		root.val = -1;
	}

	class Node{
		public int val;
		public Node right, left;
		public Node(){
			//Do Nothing
		}
	}
	
	public static void insert(Node root, int val){
		if(root.val == -1){
			root.val = val;
		} else if(root.val == val){
			System.out.println("Already Exists in Tree");
		} else if (val < root.val){
			if(root.left == null){
				root.left = new BST().root;
				root.left.val = val;
			} else{
			insert(root.left, val);
			}
		} else {
			if(root.right == null){
				root.right = new BST().root;
				root.right.val = val;
			} else{
			insert(root.right, val);
			}
		}
	}
	
	public static Node search(Node root, int val){
		if(root.val == -1){
			System.out.println("empty tree");
			return null;
		} else if (root.val == val){
			return root;
		} else if (val < root.val){
			return search(root.left, val);
		} else {
			return search(root.right, val);
		}
	}
	
	public static void delete(Node root, int val){
		if(root.val == -1){
			System.out.println("Tree is empty");
		} else if(root.val == val){
			int lowInRight = findLowestInRightSubtree(root);
			root.val = lowInRight;
		} else if((root.left).val == val){
			deleteThisNode(root.left, root, 0);
		} else{
			deleteThisNode(root.right, root, 1);
		}
	}
	
	public static void deleteThisNode(Node node, Node parent, int lor){//lor=0 is left, lor=1 is right
		if(node.left == null && node.right == null){
			if(lor == 0){
				parent.left = null;
			} else{
				parent.right = null;
			}
		} else if(node.left != null && node.right == null){
			if(lor == 0){
				parent.left = node.left;
			} else{
				parent.right = node.left;
			}
		} else if(node.left == null && node.right != null){
			if(lor == 0){
				parent.left = node.right;
			} else{
				parent.right = node.right;
			}
		} else{
			int lowInRight = findLowestInRightSubtree(node);
			node.val = lowInRight;
		}
	}
	
	public static int findLowestInRightSubtree(Node node){
		Node current = node.right;
		Node parent = node;
		int val;
		if(current.left == null){
			val = current.val;
			deleteThisNode(current, parent, 1);
			return val;
		} else{
			while(current.left != null){
				parent = current;
				current = current.left;
			}
			val = current.val;
			deleteThisNode(current, parent, 0);
			return val;
		}
	}
	
	public static void printInOrder(Node root){
		if(root.left == null && root.right == null){
			System.out.print(root.val + " ");
		} else if(root.left != null && root.right == null){
			printInOrder(root.left);
			System.out.print(root.val + " ");
		} else if(root.left == null && root.right != null){
			System.out.print(root.val + " ");
			printInOrder(root.right);
		} else{
		printInOrder(root.left);
		System.out.print(root.val + " ");
		printInOrder(root.right);
		}
	}
	
	public static void printPreOrder(Node root){
		if(root.left == null && root.right == null){
			System.out.print(root.val + " ");
		} else if(root.left != null && root.right == null){
			System.out.print(root.val + " ");
			printPreOrder(root.left);
		} else if(root.left == null && root.right != null){
			System.out.print(root.val + " ");
			printPreOrder(root.right);
		} else{
		System.out.print(root.val + " ");
		printPreOrder(root.left);
		printPreOrder(root.right);
		}
	}
	
	/*public static void printDiagram(Node root){
		Stack<Node> nodeStack = new Stack<Node>();
		nodeStack.push(root);
		int numNodesToPop = 1;
		while(!nodeStack.isEmpty()){
			ArrayList<Node> childrenToPush = new ArrayList<Node>();
			for(int i = 0; i < numNodesToPop; i++){
				Node current = nodeStack.pop();
				System.out.print(current.val);
				childrenToPush.add(current.right);
				childrenToPush.add(current.left);
			}
			for(int i = 0; i < childrenToPush.size(); i++){
				nodeStack.push(childrenToPush.get(i));
			}
			System.out.println("");
			numNodesToPop = numNodesToPop * 2;
		}
		
	}*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST bst = new BST();
		insert(bst.root, 4);
		insert(bst.root, 2);
		insert(bst.root, 6);
		insert(bst.root, 1);
		insert(bst.root, 3);
		insert(bst.root, 5);
		insert(bst.root, 7);
		printInOrder(bst.root);
		System.out.println("");
		printPreOrder(bst.root);
		System.out.println();
		delete(bst.root, 4);
		printInOrder(bst.root);
		System.out.println("");
		printPreOrder(bst.root);
		//printDiagram(bst.root);
	}

}
