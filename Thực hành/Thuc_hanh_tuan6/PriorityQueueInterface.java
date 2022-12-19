
public interface PriorityQueueInterface<K , E> implements Entry {
    public int size();
    public boolean isEmpty();  
    public void insert(Entry<K, E> entry);  //thêm một entry vào PQ
    public void insert(K k, E e);	//thêm phẩn tử có key k và giá trị e vào PQ
    public Entry<k, E> removeMin();     //loại phần tử có giá trị nhỏ nhất 
    public Entry<k, E> min();           //trả về phần tử có key nhỏ nhất  
    }
