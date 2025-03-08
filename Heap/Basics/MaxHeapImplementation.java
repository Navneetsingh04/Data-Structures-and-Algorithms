import java.util.ArrayList;
public class MaxHeapImplementation {
    public ArrayList<Integer> heap;
    public MaxHeapImplementation(){
        heap = new ArrayList<>();
    }
    public int parent(int i){
        return (i-1)/2;
    }
    public int leftChild(int i){
        return 2*i+1;
    }
    public int rightChild(int i){
        return 2*i+2;
    }
    public void swap(int i,int j){
        int temp = heap.get(i);
        heap.set(i,heap.get(j));
        heap.set(j,temp);
    }
    public void insert(int value){
        heap.add(value);
        int currIndex = heap.size()-1;

        while(currIndex > 0 && heap.get(currIndex) > heap.get(parent(currIndex))){
            swap(currIndex, parent(currIndex));
            currIndex = parent(currIndex);
        }
    }
    // Extracts and returns the maximum value from the heap
    public int extractMax(){
        if(heap.isEmpty()){
            System.out.println("Heap is Empty");
        }
        int max = heap.get(0);
        int lastElement = heap.remove(heap.size()-1);
        if(!heap.isEmpty()){
            heap.set(0,lastElement);

            int currIndex = 0;
            while(true){
                int left = leftChild(currIndex);
                int right = rightChild(currIndex);
                int largest = currIndex;

                if(right < heap.size() && heap.get(right) > heap.get(largest)) {
                    largest = left;
                }
                if(right < heap.size() &&  heap.get(right) > heap.get(largest)){
                    largest = right;
                }
                if(largest == currIndex){
                    break;
                }
                swap(currIndex,largest);
            }
        }
        return max;
    }
    public boolean isEmpty(){
        return heap.isEmpty();
    }
    public static void main(String[] args) {
        MaxHeapImplementation  maxHeap = new MaxHeapImplementation();
        
           // Insert values into the max heap
           maxHeap.insert(10);
           maxHeap.insert(5);
           maxHeap.insert(15);
           maxHeap.insert(20);
           maxHeap.insert(25);
   
           
           System.out.println("Extracted Max: " + maxHeap.extractMax());
           System.out.println("Extracted Max: " + maxHeap.extractMax());
    }
}
