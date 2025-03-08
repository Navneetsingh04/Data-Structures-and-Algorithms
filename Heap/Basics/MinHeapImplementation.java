/**
 * The MinHeapImplementation class defines a min-heap data structure with methods to insert elements
 * and extract the minimum value.
 */
import java.util.ArrayList;

public class MinHeapImplementation {
    public ArrayList<Integer> heap;
    public MinHeapImplementation(){
        heap = new ArrayList<>();
    } 
    // Returns the index of the parent node
    public int parent(int i){
        return (i-1)/2;
    }
    // Returns the index of the left child node
    public int leftChild(int i){
        return 2*i+1;
    }
    // Returns the index of the right child node
    public int rightChild(int i){
        return 2*i+2;
    }
    // Swaps the elements at indices i and j
    public void swap(int i,int j){
        int temp = heap.get(i);
        heap.set(i,heap.get(j));
        heap.set(j,temp);
    }
    // Inserts a new value into the heap
    public void insert(int value){
        heap.add(value);
        int currIndex = heap.size()-1;
        while(currIndex > 0 && heap.get(currIndex) < heap.get(parent(currIndex))){
            swap(currIndex, parent(currIndex));
            currIndex = parent(currIndex);
        }
    }
    
    // Extracts and returns the minimum value from the heap
    public int extractMin(){
        if(heap.isEmpty()){
            System.out.println("Heap is Empty");
        }
        int min = heap.get(0);
        int lastElement = heap.remove(heap.size()-1);

        if(!heap.isEmpty()){
            // Move the last element to the root
            heap.set(0,lastElement);
        }
        int currIndex = 0;
        while(true){
            int left = leftChild(currIndex);
            int right = rightChild(currIndex);
            int smallest = currIndex;

            // Find the smallest value among current, left child, and right child

            if(left < heap.size() && heap.get(left) < heap.get(smallest)){
                smallest = left;
            }
            else if(right < heap.size() &&  heap.get(right) < heap.get(smallest)){
                smallest = right;
            }
            else if(smallest == currIndex){
                // Heap property is restored
                break;
            }
            swap(currIndex, smallest);
            currIndex = smallest;
        }
        return min;
    }
    public static void main(String[] args) {
        MinHeapImplementation minHeap = new MinHeapImplementation();
        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(15);
        minHeap.insert(20);
        minHeap.insert(25);
        System.out.println("Extracted Min: " + minHeap.extractMin());
        System.out.println("Extracted Min: " + minHeap.extractMin());
    }
}
