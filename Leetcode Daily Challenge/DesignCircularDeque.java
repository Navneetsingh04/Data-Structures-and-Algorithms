/*
L.C: 641. Design Circular Deque
Solved
Medium
Topics
Companies
Design your implementation of the circular double-ended queue (deque).

Implement the MyCircularDeque class:

MyCircularDeque(int k) Initializes the deque with a maximum size of k.
boolean insertFront() Adds an item at the front of Deque. Returns true if the operation is successful, or false otherwise.
boolean insertLast() Adds an item at the rear of Deque. Returns true if the operation is successful, or false otherwise.
boolean deleteFront() Deletes an item from the front of Deque. Returns true if the operation is successful, or false otherwise.
boolean deleteLast() Deletes an item from the rear of Deque. Returns true if the operation is successful, or false otherwise.
int getFront() Returns the front item from the Deque. Returns -1 if the deque is empty.
int getRear() Returns the last item from Deque. Returns -1 if the deque is empty.
boolean isEmpty() Returns true if the deque is empty, or false otherwise.
boolean isFull() Returns true if the deque is full, or false otherwise.
 

Example 1:

Input
["MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", "getRear", "isFull", "deleteLast", "insertFront", "getFront"]
[[3], [1], [2], [3], [4], [], [], [], [4], []]
Output
[null, true, true, true, false, 2, true, true, true, 4]

Explanation
MyCircularDeque myCircularDeque = new MyCircularDeque(3);
myCircularDeque.insertLast(1);  // return True
myCircularDeque.insertLast(2);  // return True
myCircularDeque.insertFront(3); // return True
myCircularDeque.insertFront(4); // return False, the queue is full.
myCircularDeque.getRear();      // return 2
myCircularDeque.isFull();       // return True
myCircularDeque.deleteLast();   // return True
myCircularDeque.insertFront(4); // return True
myCircularDeque.getFront();     // return 4
 

Constraints:

1 <= k <= 1000
0 <= value <= 1000
At most 2000 calls will be made to insertFront, insertLast, deleteFront, deleteLast, getFront, getRear, isEmpty, isFull. 
*/
public class DesignCircularDeque {
    private int[] deq;        
    private int k;             
    private int front;        
    private int rear;          
    private int currentCount; 
    public DesignCircularDeque(int k) {
        this.k = k;
        deq = new int[k];      
        front = 0;
        rear = k - 1;
        currentCount = 0;
    }

    // Insert element at the front of the deque
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + k) % k;
        deq[front] = value;
        currentCount++;
        return true;
    }

    // Insert element at the rear of the deque
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        rear = (rear + 1) % k;
        deq[rear] = value;
        currentCount++;
        return true;
    }

    // Delete element from the front of the deque
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % k;
        currentCount--;
        return true;
    }

    // Delete element from the rear of the deque
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear - 1 + k) % k;
        currentCount--;
        return true;
    }

    // Get the front element of the deque
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return deq[front];
    }

    // Get the rear element of the deque
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return deq[rear];
    }

    // Check if the deque is empty
    public boolean isEmpty() {
        return currentCount == 0;
    }

    // Check if the deque is full
    public boolean isFull() {
        return currentCount == k;
    }
    public static void main(String[] args) {
        DesignCircularDeque deque = new DesignCircularDeque(5);
        deque.isFull();
    }
}