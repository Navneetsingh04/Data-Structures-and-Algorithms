public class MaxHeapify {
    int arr[];
    int maxSize;
    int heapSize;

    MaxHeapify(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        heapSize = 0;
    }
    public void swap(int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void insert(int val){
        if(heapSize == maxSize){
            System.out.println("Heap overflow");
            return;
        }
        arr[heapSize] = val;
        int index = heapSize;
        heapSize++;

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
    public void heapify(int arr[],int n,int index){
        int leftIndex = 2*index+1;
        int rightIndex = 2*index+2;
        int largestIndex = index;

        // find maximum among all three 
        if(leftIndex < n && arr[leftIndex] > arr[largestIndex]){
            largestIndex = leftIndex;
        }
        if(rightIndex < n && arr[rightIndex] > arr[largestIndex]){
            largestIndex = rightIndex;
        } 
        if(index != largestIndex){
            swap(index, largestIndex);
            index = largestIndex;
            heapify(arr, n, index);
        }
    }
    public void printHeap(){
        for(int i = 0; i <heapSize; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        MaxHeapify heap = new MaxHeapify(10);
        heap.insert(10);
        heap.insert(20);
        heap.insert(15);
        heap.insert(30);
        heap.insert(40);

        System.out.print("Heap array before manual heapify: ");
        heap.printHeap();

        
        heap.arr[0] = 5;
        System.out.print("\nHeap array after altering root: ");
        heap.printHeap();
        
        System.out.print("\nHeap array after heapify: ");
        heap.heapify(heap.arr, heap.heapSize, 0);
        heap.printHeap();
    }
}
