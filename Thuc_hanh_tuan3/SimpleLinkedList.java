import java.util.Iterator;

public class SimpleLinkedList<T> { 
    class Node { 
        T data; 
        Node next; 

        public Node(T data) {
            this.data = data;
            next = null;
        }
    } 
    private Node top = null;  
    private Node bot = null;  
    private int n = 0; 

    public void printList() {
        Node tmp = top;

        System.out.print("LinkedList: ");

        while (tmp != null) {
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public void add(T data) { 
        Node tmp = new Node(data);
        if (top == null) top = bot = tmp;
        else {
            tmp.next = top;
            top = tmp;
        }
        n++;  
    }

    public void addBot(T data) { 
        Node tmp = new Node(data);
        if (bot == null) top = bot = tmp;
        else {
            while (bot.next != null) bot = bot.next;
            bot.next = tmp;
        }
        n++;
    } 

    public T get(int i) { 
        // Lấy phần tử ở vị trí thứ i 
        if (i < n) {
            return T get(i);
        }
        return null; 
        } 
    
    public void set(int i, T data){ 
        // Gán giá trị ở vị trí i bằng data 
    } 

    public boolean isContain(T data) { 
       // Kiểm tra trong danh sách có chứa phần tử data hay không? 
       return false; 
    } 

    public int size() { 
       // Trả lại thông tin số phần tử có trong danh sách 
       return 0; 
    } 

    public boolean isEmpty() { 
       // Kiểm tra danh sách có rỗng hay không? 
       return true; 
    } 
    
    public T removeTop() { 
        // Xóa phần tử ở đầu danh sách, trả lại giá trị data của phần tử đó   		return null; 
    } 

    public T removeBot() { 
         // Xóa phần tử ở cuối danh sách, trả lại giá trị data của phần tử đó   		return null; 
    } 

    public void remove(T data) { 
       // Xóa tất cả các phần tử có giá trị bằng data 
    }
    
    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return null;
    } 
}
