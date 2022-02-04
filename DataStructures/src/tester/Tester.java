package tester;

import tools.DoublyLinkedList;

public class Tester {

	
	public static void main(String[] args) {

		DoublyLinkedList a = new DoublyLinkedList();
		
		System.out.println(a);
		
		a.addLast(9);
		a.addFirst(5);
		a.addLast(3);
		a.addFirst(3);
		a.addLast(7);
		a.addFirst(8);
		
		System.out.println(a);
		
		a.insertAt(-1, 15);
		a.insertAt(-1, 25);
		
		System.out.println(a);
		
		a.clear();
		a.insertAt(0, 7);
		
		System.out.println(a);
		
		
	}
	
	
}

