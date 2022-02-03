package tools;

public class DoublyLinkedList {

	// Internal class to represent a Node
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
	
	// Properties
	// - Reference to Head Node
	// - Reference to Tail Node
	// - Size of the List
	private Node head;
	private Node tail;
	private int numOfElems;
	
	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
		this.numOfElems = 0;
	}
	
	// Behaviours
	// - Get the size of the List
	// - Check whether the List is empty or not
	// - Add First
	// - Add Last
	// - Remove First
	// - Remove Last
	// - Insert at
	// - Remove at
	// - Check whether a value exists in the List
	// - Check WHERE the value exists
	// - toString Representation
	
}
