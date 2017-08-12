/*
 * Linked List Implemented in Java
 * 
 */
public class LinkedListUtil {
	/*
	 * Node Declaration
	 * 
	 */
	public class Node {
		private int data;
		private Node next;

		// constructor
		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}

		// getter and setter
		public void setData(int data) {
			this.data = data;
		}

		public int getData() {
			return data;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Node getNext() {
			return next;
		}
	}

	private int length = 0; // This variable wont be required, we may simply use head to compare instead
	private Node head;

	public Node getHead() {
		return head;
	}

	public void setHead(Node hed) {
		head = hed;
	}

	// insert at First ---Time Complexity ~ O(1)---
	public void insertAtBegin(int elem) {

		if (length == 0) {
			Node node = new Node(elem, null);
			head = node;
			length++;
		}

		else {
			Node node = new Node(elem, head);
			head = node;
			length++;
		}

	}

	// insert at Last ---Time Complexity ~ O(n)---
	public void insertAtLast(int elem) {

		if (length == 0) {
			Node node = new Node(elem, null);
			head = node;
			length++;
		}

		else {
			Node node = head;
			while (node.next != null) {
				node = node.next;
			}
			Node newNode = new Node(elem, null);
			node.next = newNode;
			length++;

		}

	}

	// Insert at a given position ---Time Complexity ~ O(pos)---
	public void insertAtPos(int elem, int pos) {
		if (pos == 1) {
			insertAtBegin(elem);
		}
		if (pos > length) {
			System.out.println("Cant find the position");
		}
		if (length == 0) {
			Node node = new Node(elem, null);
			head = node;
			length++;
		}

		else {
			Node h = head;
			int count = 2;
			while (count < pos) {
				h = h.next;
				count++;
			}
			Node newNode = new Node(elem, h.next);
			h.next = newNode;
			length++;

		}

	}
}
