//Problems and solution on Linked List
/*
 * Find The nth Node from end of the List
 * 
 */

public int nthNodeFromEnd(int n){
	/*
	 * This is going to be simple as we know the length of the List in declaration
	 * We have to return length - n + 1 element from begining
	 */
	Node h = head;
	int counter = 1;
	while (counter<length-n+1){
		h = h.next;
		counter++;
	}
	
	return h.data;
}

/*
 * Other approach is to use a hash table but that would take O(n) space complexity
 * Another efficient approach without using the length data
 * Using two pointers - Traverse the first pointer till n nodes keeping the other pointer fixed
 * Then Traverse both the pointers till the first pointer reaches end. 
 * Time Complexity ~ O(n) 	
 */

public int nthNodeFromEnd_using2ptrs(int n){
	Node h1 = head;
	Node h2 = head;
	int counter = 1;
	while (counter<=n){
		h1 = h1.next;
		counter++;
	}
	
	while (h1 != null){
		h1 = h1.next;
		h2= h2.next;
	}
	
	return h2.data;
}

/*
 * Floyd algorithm to find the cycle in linked list
 * Other approaches are to use a hash table
 * Bruteforce or sorting will not work due to the loop, It may go in infinite cycle
 * 
 */
public boolean findCycle_Using_Floyd_Algorithm(){
	Node slowptr = head;
	Node fastptr = head;
	
	while (slowptr.next != fastptr.next.next || fastptr.next==null || slowptr.next == null){
		slowptr = slowptr.next;
		fastptr = fastptr.next.next;
	}
	
	if (slowptr.next == fastptr.next.next){
		return true;
	}
	
	
	return false;
}

/*
 * Find the start node of the loop if there is a cycle
 * Awsome solution using Floyd algorithm
 * 
 */

public Node findStartNodeOfLoop(){
	Node slowptr = head;
	Node fastptr = head;
	
	while (slowptr.next != fastptr.next.next || fastptr.next==null || slowptr.next == null){
		slowptr = slowptr.next;
		fastptr = fastptr.next.next;
	}
	
	if (slowptr.next == fastptr.next.next){
		fastptr = fastptr.next.next;
		slowptr = head;
	}
	
	while(slowptr.next != fastptr.next){
		slowptr = slowptr.next;
		fastptr = fastptr.next;
	}
	
	return slowptr.next;
}

/*
 * Reversing a Linked List
 * 
 */

public void reverseList(){
	Node prev = null;
	Node current = head;
	Node next;
	
	while (current != null){
		next = current.getNext();
		current.setNext(prev);
		prev = current;
		head=current;
		current = next;

		
	}
	
}

/*
 * Reversing a linked list - Recursive method
 * Below code will just reverse the display, It will not actually reverse the list
 * 
 */

public void reverseListDisplay_Util(Node temp_head){
	
	if (temp_head != null){
		reverseListDisplay_Util(temp_head.next);
		System.out.println(temp_head.data);
	}
	else{
		return;
	}
}



/*
 * Finding the middle of the Linked list using two pointers
 * Below Algorithm works only when list has odd number of elements
 * Using two pointers fast pointer runs with doble the speed of the slow pointer
 * While the fast pointer reaches end slow pointer is at the middle of the list
 * Time Complexity ~ O(n)
 * 
 */

public void findMiddle(){
	Node slowptr = head;
	Node fastptr = head;
	
	while (fastptr.next !=null){
		fastptr = fastptr.next.next;
		slowptr = slowptr.next;
	}
	
	System.out.println(slowptr.data);
	
}

/*
 * Find whether the length of a list is even or odd
 * 
 */

public void evenOdd(){
	Node fastptr = head;
	
	while (fastptr != null && fastptr.getNext() != null) {
		fastptr = fastptr.next.next;
		
	}
	
	if (fastptr == null){
		System.out.println("Even");
	}
	else{
		System.out.println("Odd");
	}
	
}

