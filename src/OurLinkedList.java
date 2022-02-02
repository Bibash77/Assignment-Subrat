public class OurLinkedList< T> implements OurList< T> {

		private Node head;

	  public class Node {
	    public T value;
	    public Node next;

	    public Node(T value, Node next) {
	      this.value = value;
	      this.next = next;
	    }
	  }
	  
	public int size() {             //return number of values in the list
		Node curr = head;
		int count = 0;
		while(curr != null) {
			count++;
			curr = curr.next;
		}
		return count;
	}
	
	public boolean contains(T s) {  //return whether s is in the list
		Node curr = head;
		while(curr != null) {
			if(curr.value.equals(s))
				return true;
			curr = curr.next;
		}
		return false;
	}
	
	public void add(T s) {          //add s to the end of the list
		if(head == null) {
			head = new Node(s, null);
			return;
		}
		
		Node curr = head;
		while(curr.next !=null)
			curr = curr.next;
		Node newNode = new Node(s, null);
		curr.next = newNode;
	}
	
	public T get(int i) {          //returns value at index i
		Node curr = head;
		int index = 0;
		while(curr != null) {
			if(index == i)
				return curr.value;	
			curr = curr.next;
			index++;
		}
		throw new IndexOutOfBoundsException();
	}
	
	/*
	//first implementation (two references marching down the list together)
	public boolean remove(T item) {
		Node curr = head;
		Node prev = null;

		if(head == null)				//special case: empty list
			return false;
		if(curr.value.equals(item)) {	//special case: adding to front
			head = curr.next;
			return true;
		}
		
		while(curr != null) {
			if(curr.value.equals(item)) {
				prev.next = curr.next;
				return true;
			}
			prev = curr;
			curr = curr.next;	
		}
		return false;
	}
	*/
	
	//second implementation: just one reference, looking for Node before one to remove:
	public boolean remove(T item) {
		Node curr = head;
		
		if(head == null)				//special case: empty list
			return false;
		if(curr.value.equals(item)) {	//special case: adding to front
			head = curr.next;
			return true;
		}
		
		while(curr.next != null) {
			if(curr.next.value.equals(item)) {
				curr.next = curr.next.next;
				return true;
			}
			curr = curr.next;	
		}
		return false;
	}

	@Override
	public void firstIndexAfter(T s, int i) {

	}

	@Override
	public void moveLater(T s, T t) {

	}
}
