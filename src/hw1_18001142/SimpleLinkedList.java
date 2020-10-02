package hw1_18001142;

public class SimpleLinkedList<T> {
	class Node{
		T data;
		Node next;
		Node(T d){
			data = d;
			next = null;
		}
	}
	private Node head = null;
	private Node tail = null;
	private int n = 0;
	
	public void add(T data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
	}
	
	public void append(T data) {
		Node node = new Node(data);
		// Linked List check_empty
		if(head == null) {
			head = node;
			return;
		}
		
		// Get tail
		Node temp = head;
		while(temp.next != null){
			temp = temp.next;
		}
		
		temp.next = node;
	}
	
	public T get(int position) {
		int i = 0;
		Node node = head;
		while(i < position - 1){
			i++;
			node = node.next;
		}
		
		return node.data;
	}
	
	public void set(int position, T data) {
		// Get Node at position
		int i = 0;
		Node node = head;
		while(i < position - 1){
			i++;
			node = node.next;
		}
		
		node.data = data;
	}
	
	public boolean isContain(T data) {
		Node node = head;
		
		while(node != null) {
			if(node.data.equals(data)) {
				return true;
			}
			node = node.next;
		}
		
		return false;
	}
	
	public int size() {
		int nodes = 0;
		Node node = head;
		
		while(node != null) {
			nodes++;
			node = node.next;
		}
		
		return nodes;
	}
	
	public boolean isEmpty() {
		if(head == null) return true;
		else return false;
	}
	
	public T removeHead() {
		// Check Linked List
		if(head == null) return null;
		
		Node node = head;
		head = node.next;
		
		return node.data;
	}
	
	public T removeTail() {
		// Check Linked List
		if(head == null) return null;
		
		// Check linked List size = 1
		if(head.next == null) {
			head = null;
			return null;
		}
		
		// Get previous Node of tail
		Node node = head;
		while(node.next.next != null){
			node = node.next;
		}
		
		T data = node.next.data;
		node.next = null;
		
		return data;
	}
	
	public void print() {
		Node node = head;
		while(node != null) {
			System.out.print(node.data + "    ");
			node = node.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.append(3);
		list.append(4);
		list.removeTail();
		list.set(1, 15);
		list.print();
		System.out.println("Position 2:" + list.get(2));
		
		
	}
}
