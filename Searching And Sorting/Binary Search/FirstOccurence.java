// package Binary Search;
// Time complexity : O(logn)
public class FirstOccurence {
    public static int firstOccurence(int arr[],int target){
        int n = arr.length;
        int s = 0,end = n-1;
        int ans = -1;
        while(s<=end){
            int mid = s+(end-s)/2;
            if(arr[mid]==target){
                // store ans
                ans = mid;
                // move to left
                end = mid-1;
            }
            else if(arr[mid]<target){
                s = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = new int[]{10,20,30,30,40,40,50};
        int target = 40;
        System.out.println("printing the input array");
        for(int i:arr){
            System.out.print(i+" ");
        }
        int result = firstOccurence(arr, target);
        if(result != -1){
            System.out.println("\nFirst Occurenec the elemnet is "+result+" index");
        }
        else{
            System.out.println("Element is not there");
        }
    }
}
