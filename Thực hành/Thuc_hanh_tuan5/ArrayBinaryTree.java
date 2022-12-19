package Thuc_hanh_tuan5;

public class ArrayBinaryTree<E,T> implements BinaryTreeInterface<T> {
	private E [] array;
	private int n = 0;	
	private int defaultsize = 100;
	
	public ArrayBinaryTree(){
		array = (E[]) new Object[defaultsize]; 
 	}
	//update methods
 	public void setRoot(E element) {	
		array[1] = element;
		if (n == 0) n++;
	 	// Set element to root of an empty tree (at index 1)
 	}
 	public void setLeft(int p, E element) {
		int index = 2 * p;
		if (array[p] == null) {
			System.out.printf("can not set value of element %d, because it has not parent element", index);
		} else {
			array[index] = element;
			n++;
		}
	 	// Set left child of p (at index 2p)
	}
	public void setRight(int p, E element) {
	 	// Set right child of p (at index 2p+1)
		int index = 2 * p + 1;
		if (array[p] == null) {
			System.out.printf("can not set value of element %d, because it has not parent element", index);
		} else {
			array[index] = element;
			n++;
		}
  	} 	

	public E getRoot() {
		return array[1];
	}

	public E getValue(T e) {
		if (e != null) return array[(int) e];
		return null;
	}

	@Override
	public T root() {
		return (T) array[1];
	}

	@Override
	public int size() {
		return n;
	}

	@Override
	public boolean isEmpty() {
		return n==0;
	}

	@Override 
	public int numChildren(T p) {
		if (p == null) {
			return 0;
		} else{
			int num = 1;
			num += numChildren(((BinaryTreeInterface<T>) p).left(p));
			num += numChildren(((BinaryTreeInterface<T>) p).right(p));
			return num;
		}
	}

	@Override
	public T parent(T p) {
		return (T) array[(int)p/2];
	}

	@Override
	public T left(T p) {
		return (T) array[(int)p * 2];
	}

	@Override
	public T right(T p) {
		return (T) array[((int)p * 2) + 1];
	}

	@Override 
	public T sibling(T p) {
		T parent = parent(p);
		if (parent == null) return null;
		else if (p == left(parent)) {
			return right(parent);
		} else if (p == right(parent)) {
			return left(parent);
		}
		return null;
	}
}

