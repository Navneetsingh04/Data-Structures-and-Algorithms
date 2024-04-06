import java.util.Arrays;
public class CyclicSort {
    static void cyclicSort(int arr[]){
        int i = 0;
        while(i<arr.length){
            int correctIndex = arr[i]-1;
            if(arr[i] != arr[correctIndex]){
                int temp  = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            }
            else{
            i++;
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = new int[]{7,5,6,3,4,1,8,2};
        System.out.print("Array before Sorting: ");
        System.out.println(Arrays.toString(arr));
        System.out.print("Array after Sorting: ");
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
 