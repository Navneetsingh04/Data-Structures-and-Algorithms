// Time complexity : O(logn)

public class Insertion {
    int arr[];
    int maxSize;
    int heapSize;

    Insertion(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        // current element in heap
        heapSize = 0;
    }
    public void swap(int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void insert(int val){
        if(heapSize == maxSize){
            System.out.println("Heap Overflow");
            return;
        }
        // Increment size and inserting the new element at the end
        arr[heapSize] = val;
        int index = heapSize;
        heapSize++;
        // taking  value to its correct position
        while(index > 0){
            int parentIndex = (index-1)/2;
            if(arr[index] > arr[parentIndex]){
                swap(index,parentIndex);
                index = parentIndex;
            }
            else{
                break;
            }
        }
    }
    public static void main(String[] args) {
        Insertion heap = new Insertion(20);
        // heap.insert(10);
        // heap.insert(20);
        // heap.insert(5);
        // heap.insert(11);
        // heap.insert(6);

        heap.insert(5);
        heap.insert(10);
        heap.insert(15);
        heap.insert(6);
        heap.insert(25);
        heap.insert(50);

        System.out.print("Printing the content of the heap: ");
        for(int i = 0;i<heap.heapSize;i++){
            System.out.print(heap.arr[i]+" ");
        }
    }
}