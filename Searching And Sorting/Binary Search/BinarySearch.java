public class BinarySearch{
    public static int binarySearch(int arr[],int target){
        int n = arr.length;
        int s = 0;
        int end = n-1;
        while(s<=end){
            int mid = s+(end-s)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid]<= target){
                s = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        int arr[] = new int[]{1,3,5,7,8,12,15,19,20,42,45,99};
        int target = 1;
        int result = binarySearch(arr, target);
        if(result != -1){
            System.out.println("Element found at "+ result+" index");
        }
        else{
            System.out.println("Elemnet not found");
        }
    }
}
