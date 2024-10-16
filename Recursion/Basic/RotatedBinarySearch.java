public class RotatedBinarySearch {
    public static int search(int arr[],int target,int s,int e){
        if(s > e){
            return -1;
        }
        int mid = s+(e-s)/2;
        if(arr[mid] == target){
            return mid;
        }
        if(arr[mid]>=arr[s]){
            if(arr[s] <= target && target <= arr[mid]){
                return search(arr, target, s, mid-1);
            }
            else{
                return search(arr, target, mid+1, e);
            }
        }
        else{
            if(arr[mid] <= target && target <= arr[e]){
                return search(arr, target, mid+1, e);
            }
            else{
                return search(arr, target, s, mid-1);
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = new int[]{4,5,6,7,8,9,1,2,3};
        int target = 3;
        int s = 0;
        int e = arr.length-1;
        int result = search(arr, target, s, e);
        if(result != -1){
            System.out.println(target+" is found at Index "+result);
        }
        else{
            System.out.println(target+" elemnt is not found");
        }
    }
}
