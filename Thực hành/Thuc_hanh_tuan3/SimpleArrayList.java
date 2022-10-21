import java.util.Iterator;
    
    //Tạo lớp SimpleArrayList cài đặt giao diện ListInterface 
public class SimpleArrayList<T> implements ListInterface<T> {  
	private T[] array;  
	private int n = 0; 
 	private int defaultSize = 100; 
 
 	public SimpleArrayList() { 
	  	array = (T[]) new Object[defaultSize]; 
 	} 
  	public SimpleArrayList(int capacity) {   	
		// Hàm dựng với kích thước mảng là capacity 
	  	array = (T[]) new Object[capacity]; 
 	} 

	@Override
 	public void add(T data) { 
		if (n == array.length) {
			System.out.println("Array is full");
		} else {
			array[n++] = data;
		}
    } 

	@Override
  	public T get(int i) {   		
        return array[i];
 	} 

	@Override
	public void set(int i, T data) { 
		if (i < 0 || i >= n) {
			System.out.println("Index out of bound");
		} else {
			array[i] = data;
		}
	} 

	@Override
 	public void remove(T data) { 

        int i = 0;
        while (array[i] != data && i < n) i++;
        if (i > n) System.out.println("Cannot find the Object");
        else {
            for (int j = i; j < array.length - 1; j++) array[j] = array[j + 1];
        }
        n--;
	} 

	@Override
  	public boolean isContain(T data) { 
        boolean result = false;
        for (int i = 0; i < n; i++) {
            if (array[i].equals(data)) {
                result = true;
                break;
            }
        }
        return result;
	} 

	@Override
  	public int size() { 
        return n;
 	} 

	@Override
  	public boolean isEmpty() {   
        return (n == 0);
	} 


 	
            

	private class IterArray<T> implements Iterator<T> {
		int i = 0;

		@Override
		public boolean hasNext() {
			return i < n;
		}

		@Override
		public T next() {
			if (hasNext()) return (T) array[i++];
			return null;
		}
	}

	@Override
	public Iterator<T> iterator() {  
        return new IterArray();
	}
} 

   
