import java.util.Scanner;
public class BinarySearch {
    public static int binarySearch(int[] arr,int start,int end,int target){
        if(start>end){
            return -1;
        }
        int mid = start+(end-start)/2;
        if(arr[mid] == target){
            return mid;
        }
        else if(arr[mid]<target){
            return binarySearch(arr, mid+1,end, target);
        }
        else{
            return binarySearch(arr, 0, mid-1, target);
        }
       
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int arr[] = new int[]{1,4,7,9,14,15,18,25,42,45,63,93};
        System.out.print("Enter the Target Element: ");
        int target =  s.nextInt();
        int result = binarySearch(arr, 0, arr.length-1, target);
        if (result == -1) {
            System.out.println(target+" is not found in the array");
        }
        else{
            System.out.println(target+" is found at index "+result);
        }
        s.close();
    }
}
