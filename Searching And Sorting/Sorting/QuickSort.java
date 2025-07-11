public class QuickSort {
    public static void swap(int arr[],int i ,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    // Lomuto Partition Scheme (last element as pivot)
    public static void quickSortLomuto(int arr[], int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = arr[end]; 
        int i = start - 1;
        int j = start;
        while(j < end) { 
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
            j++;
        }
        i++; 
        swap(arr, i, end);
        quickSortLomuto(arr, start, i - 1);
        quickSortLomuto(arr, i + 1, end);
    }

    // Hoare Partition Scheme (first element as pivot)

    public static void quickSortHoare(int arr[],int start,int end) {
        if (start >= end) return;
        int pivot = arr[start]; 
        int i = start - 1;
        int j = end + 1;
        while(true){
            do{
                i++;
            } 
            while(arr[i] < pivot);
            do{
                j--;
            }
            while (arr[j] > pivot);
            if(i>=j){
                break;
            }
            swap(arr, i, j);
        }
        quickSortHoare(arr,start,j);
        quickSortHoare(arr,j+1,end);
    }   
    public static void main(String[] args) {
        int arr[] = new int[]{7, 2, 1, 8, 6, 3, 5, 4};
        int start = 0;
        int end = arr.length - 1;
        quickSortLomuto(arr, start, end);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
