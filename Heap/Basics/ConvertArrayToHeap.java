// Time complexity : O(N)

public class ConvertArrayToHeap {
    int maxSize;
    ConvertArrayToHeap(int maxSize){
        this.maxSize = maxSize;
    }
    public void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
            swap(arr,index, largestIndex);
            index = largestIndex;
            heapify(arr, n, index);
        }
    }
    public void buildHeap(int arr[],int size){
        for(int i = size/2-1;i>=0;i--){
            heapify(arr,size,i);
        }
    }  
    public void printHeap(int arr[]){
        for(int i = 0; i <arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {5,10,15,20,25,12};
        ConvertArrayToHeap obj = new ConvertArrayToHeap(arr.length);
        obj.buildHeap(arr, arr.length);
        System.out.print("Heap array after building: ");
        obj.printHeap(arr);
    }
}
