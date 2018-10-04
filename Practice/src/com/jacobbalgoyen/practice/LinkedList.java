package com.jacobbalgoyen.practice;

public class LinkedList {
	Node head;
	Node tail;
	
	class Node{
		int val;
		Node next;
		
		public Node(int val){
			this.val = val;
			this.next = null;
		}
		
		public int getVal() {
			return val;
		}
		public void setVal(int val) {
			this.val = val;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
	}
	
	public LinkedList(){
		this.head = null;
		this.tail = null;
	}
	
	public void insert(int val){
		Node node = new Node(val);
		if(this.head == null){
			this.head = node;
			this.tail = node;
		} else if(this.head == this.tail){
			this.head.setNext(node);
			this.tail = node;
		} else{
			this.tail.setNext(node);
			this.tail = node;
		}
	}
	
	public boolean delete(int val){
		if(this.head == null){
			return false;
		} else if(this.head.getVal() == val){
			this.head = this.head.getNext();
			return true;
		} else{
			if(this.head.getNext() != null){
				Node previous = this.head;
				Node current = this.head.getNext();
				while(current.getNext() != null){
					if(current.getVal() == val){
						previous.setNext(current.getNext());
						return true;
					} else{
						previous = current;
						current = current.getNext();
					}
				}
			}
			
		} 
		return false;
	}
	
	public void printList(){
		Node current = this.head;
		while(current.getNext() != null){
			System.out.print(current.getVal() + "--->");
			current = current.getNext();
		}
		System.out.print(current.getVal() + "--->null");
	}
	
	public static void main(String[] args) {
		LinkedList myList = new LinkedList();
		
		//test insert integers 1 through 10
		for (int i = 1; i <= 10; i++){
			myList.insert(i);
		}
		myList.printList();
		System.out.println();
		
		//test deleting 4 and 7
		myList.delete(4);
		myList.delete(7);
		myList.printList();
	}

}
