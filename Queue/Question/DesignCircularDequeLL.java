import java.util.LinkedList;

public class DesignCircularDequeLL {
    private LinkedList<Integer> deq; 
    private int cnt;              
    private int k;                    
    
    public DesignCircularDequeLL(int k) {
        this.k = k;                 
        this.deq = new LinkedList<>(); 
        this.cnt = 0;                  
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (cnt == k) {
            return false;              
        }
        deq.addFirst(value);          
        cnt++;                       
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (cnt == k) {
            return false;              
        }
        deq.addLast(value);            
        cnt++;                         
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (cnt == 0) {
            return false;              
        }
        deq.removeFirst();             
        cnt--;                        
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (cnt == 0) {
            return false;              
        }
        deq.removeLast();              
        cnt--;                        
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if (cnt == 0) {
            return -1;                 
        }
        return deq.getFirst();          
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if (cnt == 0) {
            return -1;                 
        }
        return deq.getLast();           
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return cnt == 0;               
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return cnt == k;              
    }
    public static void main(String[] args) {
        
    }
}
