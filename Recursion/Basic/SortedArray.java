public class SortedArray{
    public static boolean isSorted(int arr[],int index){
        if(index >= arr.length-1){
            return true;
        }
        if(arr[index]>arr[index+1]){
            return false;
        }
        return isSorted(arr, index+1);
        
    }
    public static void main(String[] args) {
        int arr[] =  new int[]{1,3,2,4,8,9,14,16,18};
        boolean result = isSorted(arr,0);
        if (result) {
            System.out.println("Array is sorted");
        }
        else{
            System.out.println("Array is not sorted");
        }
    }
}
