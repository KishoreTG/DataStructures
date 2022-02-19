package tools;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	
	private static final int DEFAULT_CAPACITY = 4;
	
	
	private final int capacity;
	
	private Map<Integer, DoublyLinkedList.Node> keys;
	private DoublyLinkedList values;
	private int numOfElems;
	
	
	public LRUCache() {
		this.capacity = DEFAULT_CAPACITY;
		keys = new HashMap<>();
		values = new DoublyLinkedList();
	}
	
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
	}
	
	
	public void put(int key, int value) {
		if (keys.containsKey(key)) {
			modify(key, value);
			return;
		}
		DoublyLinkedList.Node ref = values.addFirst(value);
		keys.put(key, ref);
		if (numOfElems >= capacity) {
			values.removeLast();
		} else {
			numOfElems += 1;
		}
	}
	
	
	public int get(int key) {
		DoublyLinkedList.Node nodeGot = keys.get(key);
		values.remove(nodeGot);
		values.addFirst(nodeGot);
		return nodeGot.value;
	}
	
	
	private void modify(int key, int value) {
		DoublyLinkedList.Node nodeToModify = keys.get(key);
		values.remove(nodeToModify);
		values.addFirst(nodeToModify);
		nodeToModify.value = value;
	}
	
	
	public String toString() {
		return "[" + keys.toString() + ", " + values.toString() + "]";
	}
	
}
