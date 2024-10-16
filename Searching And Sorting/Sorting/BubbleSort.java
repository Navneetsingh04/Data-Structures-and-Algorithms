import java.util.Arrays;;
public class BubbleSort {
    static void bubbleSort(int arr[]){
        int n = arr.length;
        for(int i = 0;i<n-1;i++){
            for(int j = 1;j<n-i;j++){
                if(arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = new int[]{45,8,26,89,56,2,74,10,3,69,34};
        System.out.print("Array before Sorting: ");
        System.out.print(Arrays.toString(arr)+" ");
        bubbleSort(arr);
        System.out.print("\nArray after sorting: ");
        System.out.print(Arrays.toString(arr)+" ");
    }
}
