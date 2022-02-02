
public class OurArrayList< T> implements OurList< T>{

	T[] vals;             //contents of the list (may have extra space)
	int num;              //number of values in the list

	@SuppressWarnings("unchecked")
	public OurArrayList() {
		vals = (T[]) new Object[3];
		num = 0;
	}

	public int size() {           //return number of values in the list
		return num;
	}

	@SuppressWarnings("unchecked")
	public void add(T s) {        //add s to the list
		if(num == vals.length) {  //check that the array is big enough
			T[] vals2  = (T[]) new Object[vals.length*2];
			for(int i = 0; i < vals.length; i++)
				vals2[i] = vals[i];
			vals = vals2;
		}

		vals[num] = s;
		num++;
	}

	public boolean contains(T s) {  //return whether s is in the list
		for(int i = 0; i < num; i++) {
			if(s.equals(vals[i]))
				return true;
		}
		return false;
	}

	public T get(int i) {           //returns value at index i
		if(i >= num)  //check bounds (exception for negative indices thrown below)
			throw new IndexOutOfBoundsException();
		return vals[i];
	}

	public boolean remove(T item) {
		for(int i=0; i < num; i++)
			if(vals[i].equals(item)) {
				for(int j=i; j < num-1; j++)
					vals[j] = vals[j+1];
				num--;
				return true;
			}
		return false;
	}

	@Override
	public void firstIndexAfter(T s, int i) {
		for (int j = 0; i<)
	}

	@Override
	public void moveLater(T s, T t) {

	}
}

