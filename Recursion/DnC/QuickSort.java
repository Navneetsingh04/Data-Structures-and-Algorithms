public class QuickSort {
    public static void swap(int arr[],int i ,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void quickSort(int arr[], int start, int end) {
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
        quickSort(arr, start, i - 1);
        quickSort(arr, i + 1, end);
    }
    public static void main(String[] args) {
        int arr[] = new int[]{7, 2, 1, 8, 6, 3, 5, 4};
        int start = 0;
        int end = arr.length - 1;
        quickSort(arr, start, end);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
