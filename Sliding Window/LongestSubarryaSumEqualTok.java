public class LongestSubarryaSumEqualTok {
    // Approach: Brute Force
    // Time Complexity: O(n^2)

    // public static int longestSubarray(int arr[],int k){
    //     int n = arr.length;
    //     int maxLen = 0;
    //     for(int i = 0;i<n;i++){
    //         int sum = 0;
    //         for(int j = i;j<n;j++){
    //             sum += arr[j];
    //             if(sum <= k){
    //                 maxLen = Math.max(maxLen,j-i+1);
    //             }
    //             else if(sum>k){
    //                 break;
    //             }
                
    //         }
    //     }
    //     return maxLen;
    // }

    // Approach 2: Sliding Window
    // Time Complexity: O(2n) 

    public static int longestSubarray(int arr[],int k){
        int n = arr.length;
        int l = 0,r = 0;
        int sum = 0;
        int maxLen = 0;
        while(r < n){
            sum += arr[r];
            while(sum > k){
                sum -= arr[l];
                l++;
            }
            if(sum <= k){
                maxLen = Math.max(maxLen,r-l+1);
            }
            r++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int arr[] = {2,5,1,7,10};
        int k = 13;
        System.out.println(longestSubarray(arr, k));
    }
}