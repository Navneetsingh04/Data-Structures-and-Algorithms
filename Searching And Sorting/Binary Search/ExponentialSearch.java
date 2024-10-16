public class ExponentialSearch {
    public static int binarySearch(int arr[],int s,int e,int target){
        int n = arr.length;
        s = 0;
        e = n-1;
        while(s<=e){
            int mid = s+(e-s)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] <= target){
                s = mid+1;
            }
            else{
                e = mid-1;
            }
        }
        return -1;
    }
    public static int exponentialSearch(int arr[],int target){
        int n = arr.length;
        if(arr[0] == target){
            return 0;
        }
        int i = 1;
        while(i<n && arr[i] <= target){
            i = i*2;
        }
        return binarySearch(arr,i/2,Math.min(i,n-1),target);
    }
    public static void main(String[] args) {
        int arr[] = new int[]{3,4,5,6,11,13,14,15,56,70};
        int target = 90;
        int ans = exponentialSearch(arr, target);
        if(ans != -1){
        System.out.println("Target element is found at "+ans+" index");
        }
        else{
            System.out.println("Target Element not found");
        }
    }
}
