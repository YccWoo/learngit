package com.datastruct;

public class MydoubleLinkedList {
	private Node head;
	private Node tail;
	private int size;
	
	public MydoubleLinkedList(){
		initLink();
	}
	
	public int getSize(){
		return size;
	}
	
	public void initLink(){
		head = new Node(null);
		tail = new Node(null);
		this.head = tail;
		size++;
	}
	
	public boolean isEmpty(){
		return getSize() == 0;
	}
	
	/**
	 * 根据索引查找元素，从第一个有效值开始
	 * @param index
	 * @return
	 */
	public Node getNode(int index){
		Node p;
		if(index < 0 || index > size){
			System.out.println("parm is error!");
			return null;
		}
		
		if(index < size / 2){
			p = head;
			for(int i=0; i< index; i++){
				p = p.next;
			}
		}else{
			p = tail;
			for(int j=size; j>index; j--){
				p = p.prev;
			}
			
		}
		return p;
	}
	
	public Object getData(int index){
		return getNode(index).data;
	}
	
	public boolean addHead(Object e){
		//前驱引用为null，后继为node
		Node node = new Node(e, null, this.head);
		//改变头结点的前驱和后继
		head.prev = node;
		head = node;
		if(tail == null){
			tail = this.head;
		}
		
		size++;
		return true;
	}
	
	public boolean addTail(Object o){
		if(this.head == null){
			this.head = new Node(o, null, null);
			this.tail = this.head;
		}else{
			Node node = new Node(o, this.tail, null);
			this.tail.next = node;
			this.tail = node;
		}
		size++;
		return true;
	}
	
	public boolean addData(int index, Object ele){
		if(index <0 || index > this.size){
			System.out.println("The paramter is error!");
			return false;
		}
		
		if(this.head == null){
			this.addTail(ele);
		}else{
			if(index == 0){
				addHead(ele);
			}else{
				Node p = this.getNode(index);
				Node n = p.next;
				Node node = new Node(ele, p, n);
				n.prev = node;
				p.next = node;
				size++;
						
			}
		}
		return true;
	}
	
	private static class Node{
		private Node prev;
		private Node next;
		private Object data;
		
		public Node(Node current){
			prev = current;
			next = current;
		}
		
		public Node(Object data, Node prev, Node next){
			this.data = data;
			this.prev = prev;
			this.next = next; 
		}

		public Node getPrev(){
			return prev;
		}
		
		public void setPrev(Node p){
			prev = p;
		}
		
		public Node getNext(){
			return next;
		}
		
		public void setNext(Node n){
			this.next = n;
		}
	}

}
