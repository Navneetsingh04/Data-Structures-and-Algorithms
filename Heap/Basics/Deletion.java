// Time complexity: O(logn)

public class Deletion {
    int arr[];
    int maxSize;
    int heapSize;

    Deletion(int maxSize){
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
    public int deletion(){
        if(heapSize == 0){
            System.out.println("Heap UnderFlow");
            return -1;
        }
        int ans = arr[0];
        // Replace root with the last element and decrease heap size
        arr[0] = arr[heapSize-1];
        heapSize--;

        int index = 0;
        while(index < heapSize){
            int leftIndex = 2*index+1;
            int rightIndex = 2*index+2;

            // Finding larget index
            int largestIndex = index;
            if(leftIndex < heapSize && arr[largestIndex] < arr[leftIndex]){
                largestIndex = leftIndex;
            }
            if(rightIndex < heapSize && arr[largestIndex] < arr[rightIndex]){
                largestIndex = rightIndex;
            }
            // If there is no change in largestIndex, break the loop
            if(index == largestIndex){
                break;
            }
            else{
                swap(index,largestIndex);
                index = largestIndex;
            }
        }
        return ans;

    }
    public static void main(String[] args) {
        Deletion heap = new Deletion(20);
        heap.insert(10);
        heap.insert(20);
        heap.insert(5);
        heap.insert(11);
        heap.insert(6);

        int ans = heap.deletion();
        System.out.println("Deleted element: "+ans);
        System.out.print("Printing the content of the Heap: ");
        for(int i = 0;i<heap.heapSize;i++){
            System.out.print(heap.arr[i]+" ");
        }
    }
}
