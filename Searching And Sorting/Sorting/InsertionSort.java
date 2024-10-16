import java.util.Arrays;
public class InsertionSort {
    static void insertionSort(int arr[]){
        int n = arr.length;
        for(int i = 1;i<n;i++){
            int key = arr[i];
            int j = i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
    public static void main(String[] args) {
        int arr[] = new int[]{19,4,89,48,45,15,24,212,421,51,24,21,5,12,1};
        System.out.print("Array before Sorting: ");
        System.out.println(Arrays.toString(arr));
        System.out.print("Array before Sorting: ");
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }    
}