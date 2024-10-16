// Time complexity: O(nlogn)

public class HeapSort {
    public void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void buildHeap(int arr[],int size){
        for(int i = size/2-1;i>=0;i--){
            heapify(arr,size,i);
        }
    }  
    public void heapify(int arr[],int size,int index){
        int largestIndex = index;
        int leftIndex = 2*index+1;
        int rightIndex = 2*index+2;

        if(leftIndex < size && arr[leftIndex] > arr[largestIndex]){
            largestIndex = leftIndex;
        }
        if(rightIndex < size && arr[rightIndex] > arr[largestIndex]){
            largestIndex = rightIndex;
        }
        if(index != largestIndex ){
            swap(arr, index, largestIndex);
            index = largestIndex;
            heapify(arr, size, index);
        }
    }
    public void heapSort(int arr[],int size){
        while(size > 0){
            swap(arr, 0, size-1);
            size--;
            heapify(arr, size, 0);
        }
    }
    public void printHeap(int arr[]){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = {5,10,15,20,25,12};
        HeapSort heapsort = new HeapSort();
        heapsort.buildHeap(arr, arr.length);
        System.out.print("Printing heap: ");
        heapsort.printHeap(arr);

        System.out.print("Heap Sort: ");
        heapsort.heapSort(arr, arr.length);
        heapsort.printHeap(arr);
    }
}