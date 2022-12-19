public class UnsortedArrayPriorityQueue<K extends Comparable, E> implements 
											PriorityQueueInterface {
		protected class ArrEntry<K, E> implements Entry<K, E>{
			K key;          
			E element;
			public ArrEntry (K k, E e){

			}
		}
	ArrEntry<K, E> [] array;
		int n = 0;
		int defaultsize = 1000; 
	}
