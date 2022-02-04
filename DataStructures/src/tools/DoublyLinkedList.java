package tools;

public class DoublyLinkedList {

	
	private class Node {
		
		public int value;
		public Node next;
		public Node prev;
		
		public Node(int value) {
			this.value = value;
			this.next = null;
			this.prev = null;
		}
		
		public Node(int value, Node next, Node prev) {
			this.value = value;
			this.next = next;
			this.prev = prev;
		}
		
	}
	
	
	private Node head;
	private Node tail;
	private int numOfElems;
	
	
	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
		this.numOfElems = 0;
	}
	
	
	public int size() {
		return numOfElems;
	}
	
	
	public boolean isEmpty() {
		return numOfElems == 0;
	}
	
	
	private void addCornerCase(int value) {
		Node nodeToAdd = new Node(value);
		head = nodeToAdd;
		tail = nodeToAdd;
	}
	
	
	private void removeCornerCase() {
		head = null;
		tail = null;
	}
	
	
	public void addFirst(int value) {
		if (numOfElems == 0) {
			addCornerCase(value);
		}
		else {
			Node nodeToAdd = new Node(value);
			nodeToAdd.next = head;
			head.prev = nodeToAdd;
			head = nodeToAdd;
		}
		numOfElems += 1;
	}
	
	
	public void addLast(int value) {
		if (numOfElems == 0) {
			addCornerCase(value);
		}
		else {
			Node nodeToAdd = new Node(value);
			nodeToAdd.prev = tail;
			tail.next = nodeToAdd;
			tail = nodeToAdd;
		}
		numOfElems += 1;
	}
	
	
	public void removeFirst() {
		if (numOfElems == 0) {
			return;
		}
		if (numOfElems == 1) {
			removeCornerCase();
		}
		else {
			head = head.next;
			head.prev = null;
		}
		numOfElems -= 1;
	}
	
	
	public void removeLast() {
		if (numOfElems == 0) {
			return;
		}
		if (numOfElems == 1) {
			removeCornerCase();
		}
		else {
			tail = tail.prev;
			tail.next = null;
		}
		numOfElems -= 1;
	}
	
	
	public void insertAt(int index, int value) {
		if (numOfElems == 0) {
			addCornerCase(value);
		}
		numOfElems += 1;
	}
	
	
	public void removeAt(int index) {
		if (numOfElems == 1) {
			removeCornerCase();
		}
		numOfElems -= 1;
	}
	
	
	public boolean contains(int value) {
		Node current = head;
		while (current != null) {
			if (current.value == value) {
				return true;
			}
			current = current.next;
		}
		return false;
	}
	
	
	public int indexOf(int value) {
		int index = 0;
		Node current = head;
		while (current != null) {
			if (current.value == value) {
				return index;
			}
			current = current.next;
			index += 1;
		}
		return -1;
	}
	
	
	public String toString() {
		
		StringBuilder res = new StringBuilder();
		
		Node current = head;
		while (current != null) {
			res.append(current.value + ", ");
			current = current.next;
		}
		
		// Remove the trailing comma if exists
		if (res.length() != 0) {
			res.delete(res.length() - 2, res.length());
		}
		
		res.insert(0, "[");
		res.append("]");
		
		return res.toString();
	}
	
}
