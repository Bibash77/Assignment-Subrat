
public interface OurList<T> {

	public int size();             //return number of values in the list
	public void add(T s);          //add s to the list
	public boolean contains(T s);  //return whether s is in the list
	public T get(int i);           //returns value at index i
	public boolean remove(T item); //returns whether it was there
	
	public int firstIndexAfter(T item ,int i);    //takes a value and integer index
	public void moveLater(T value);            //takes a value and moves first occurance of value one position later on list.
	


}
