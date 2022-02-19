package tester;

import tools.DoublyLinkedList;
import tools.LRUCache;

public class Tester {

	
	public static void main(String[] args) {

		LRUCache lru = new LRUCache();
		
		lru.put(3, 2);
		
		System.out.println(lru);
		
		lru.put(4, 6);
		
		System.out.println(lru);
		
		lru.put(3, 4);
		
		System.out.println(lru);
		
		lru.put(7, 8);
		
		lru.put(9, 3);
		
		System.out.println(lru);
		
		System.out.println(lru.get(4));
		
		System.out.println(lru);
		
		lru.put(5, 5);
		
		System.out.println(lru);
		
		lru.put(13, 14);
		
		System.out.println(lru);
		
	}
	
	
}

