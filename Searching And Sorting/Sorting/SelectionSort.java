import java.util.Arrays;
public class SelectionSort {
    static void selectionSort(int arr[]){
        int n = arr.length;
        for(int i = 0;i<n-1;i++){
            int minIndex = i;
            for(int j = i+1;j<n;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    public static void main(String[] args) {
        int arr[] = new int[]{19,4,89,48,45,15,24,212,421,51,24,21,5,12,1};
        System.out.print("Array before Sorting: ");
        System.out.println(Arrays.toString(arr));
        selectionSort(arr);
        System.out.print("Array before Sorting: ");
        System.out.println(Arrays.toString(arr));
    }
}
