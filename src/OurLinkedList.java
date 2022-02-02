import java.util.NoSuchElementException;

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
	public int firstIndexAfter(T item, int i) {
		Node curr = head;  // start with head
		int index = 0;
		while(curr.next != null) {
			if(index >= i && curr.value.equals(item)) {    // check if value contains after given first index
					return index;
			}
			curr = curr.next;
				index++;
		}
		return -1;  // if not found any returns -1
	}

	@Override
	public void moveLater(T item) {
		Node curr = head;  // start with head
		boolean contains = false;

		while(curr.next != null) {
			if(curr.value.equals(item)) {    // check if cur value contains the item
				contains = true;
				if(curr.next.value == null) { // check if its last element
					break;
				}
				Node tempValue = curr.next;  // store nex value in temp
				curr.next.value = curr.value;  // swap value
				curr.value = tempValue.value;
				break;             // break after the first occurrence
			}
			curr = curr.next;

		}

		if(!contains) {  // print exception if flag is false
			throw new NoSuchElementException();
		}

	}
}
