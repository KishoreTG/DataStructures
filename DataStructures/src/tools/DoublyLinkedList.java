package tools;

public class DoublyLinkedList {

	
	public class Node {
		
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
		
		public String toString() {
			return String.valueOf(value);
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
	
	
	public void clear() {
		this.head = null;
		this.tail = null;
		this.numOfElems = 0;
	}
	
	
	private Node addCornerCase(int value) {
		Node nodeToAdd = new Node(value);
		head = nodeToAdd;
		tail = nodeToAdd;
		return nodeToAdd;
	}
	
	
	private Node addCornerCase(Node nodeToAdd) {
		head = nodeToAdd;
		tail = nodeToAdd;
		return nodeToAdd;
	}
	
	
	private void removeCornerCase() {
		head = null;
		tail = null;
	}
	
	
	public Node addFirst(int value) {
		Node nodeToAdd;
		if (numOfElems == 0) {
			nodeToAdd = addCornerCase(value);
		}
		else {
			nodeToAdd = new Node(value);
			nodeToAdd.next = head;
			head.prev = nodeToAdd;
			head = nodeToAdd;
		}
		numOfElems += 1;
		return nodeToAdd;
	}
	
	
	public Node addFirst(Node nodeToAdd) {
		if (numOfElems == 0) {
			nodeToAdd = addCornerCase(nodeToAdd);
		}
		else {
			nodeToAdd.next = head;
			head.prev = nodeToAdd;
			head = nodeToAdd;
		}
		numOfElems += 1;
		return nodeToAdd;
	}
	
	
	public Node addLast(int value) {
		Node nodeToAdd;
		if (numOfElems == 0) {
			nodeToAdd = addCornerCase(value);
		}
		else {
			nodeToAdd = new Node(value);
			nodeToAdd.prev = tail;
			tail.next = nodeToAdd;
			tail = nodeToAdd;
		}
		numOfElems += 1;
		return nodeToAdd;
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
	
	
	public Node insertAt(int index, int value) {
		Node nodeToInsert;
		if (index == -1) {
			index = numOfElems;
		}
		if (index < 0 || index > numOfElems) {
			return null;
		}
		if (numOfElems == 0) {
			nodeToInsert = addCornerCase(value);
		}
		else {
			if (index == 0) {
				nodeToInsert = addFirst(value);
			} else if (index == numOfElems) {
				nodeToInsert = addLast(value);
			} else {
				int runningIndex = 0;
				Node current = head;
				while (current != null && runningIndex < index) {
					current = current.next;
					runningIndex += 1;
				}
				nodeToInsert = new Node(value);
				nodeToInsert.next = current;
				nodeToInsert.prev = current.prev;
				nodeToInsert.prev.next = nodeToInsert;
				nodeToInsert.next.prev = nodeToInsert;
			}
		}
		numOfElems += 1;
		return nodeToInsert;
	}
	
	
	public void removeAt(int index) {
		if (index == -1) {
			index = numOfElems - 1;
		}
		if (index < 0 || index >= numOfElems) {
			return;
		}
		if (numOfElems == 1) {
			removeCornerCase();
		}
		else {
			if (index == 0) {
				removeFirst();
			} else if (index == numOfElems - 1) {
				removeLast();
			} else {
				int runningIndex = 0;
				Node current = head;
				while (current != null && runningIndex < index) {
					current = current.next;
					runningIndex += 1;
				}
				current.prev.next = current.next;
				current.next.prev = current.prev;
			}
		}
		numOfElems -= 1;
	}
	
	
	public void remove(Node node) {
		if (node.prev == null) {
			head = node.next;
		} else {
			node.prev.next = node.next;
		}
		if (node.next == null) {
			tail = node.prev;
		} else {
			node.next.prev = node.prev;
		}
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

