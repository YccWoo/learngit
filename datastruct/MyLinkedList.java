package com.datastruct;

/**
 * dan lian biao
 * @author Administrator
 *
 */

public class MyLinkedList {
	
	private Node first;
	private int size;
	
	
	private static class Node{
		private int data;
		private Node next;
		
		Node(int data){
			this.data = data;
		}
	}
	
	/**
	 * insert node from the head
	 * step1. the new node's next point to the current node
	 * step2. the first point to the new node
	 * @param data
	 */
	public void insertFirst(int data){
		
		Node newNode = new Node(data);
		newNode.next = first;
		first = newNode;
		size++;
		
	}
	
	
	/**
	 * step1. set the next point of head to null
	 * step2. let the first point to the second node
	 * @return
	 */
	public boolean deleteFirst(){
		if(isEmpty()){
			return false;
		}
		
		Node secondNode = first.next;
		first.next = null;
		first = secondNode;
		size--;
		return true;
		
	}
	
	/**
	 * go through from the first node until arrive at the index node
	 * get the right node's data
	 * @param index
	 * @return
	 * @throws Exception
	 */
	public int get(int index) throws Exception{
		if(!checkIndex(index)){
			throw new Exception("index is illeagal!");
		}
		Node curr = first;
		for(int i=0; i< index; i++){
			curr = curr.next;
		}
		return curr.data;
	}
	
	/**
	 * 
	 */
	public void displayList(){
		Node currNode = first;
		while(currNode != null ){
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}
		
		System.out.println();
	}

	
	public int size(){
		return this.size;
	}

	private boolean checkIndex(int index) {
		// TODO Auto-generated method stub
		return index >= 0 && index < size;
	}


	private boolean isEmpty() {
		
		return first == null;
	}
	
	
	public static void main(String[] args) throws Exception{
		
		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.insertFirst(1);
		myLinkedList.insertFirst(2);
		myLinkedList.insertFirst(3);
		myLinkedList.insertFirst(4);
		
		myLinkedList.displayList();
		
		System.out.println(myLinkedList.get(2));
		
		myLinkedList.deleteFirst();
		myLinkedList.displayList();
		
	}

}
