
public class MaxLenSubarraySum {
    // Time complexity: O(n^2)
    // Space complexity: O(1)
    // Approach: Brute force
    public static int maxLenSubarry(int arr[],int k){
        int n = arr.length;
        int maxLen = 0;
        for(int i = 0;i<n;i++){
            int sum = 0;
            for(int j = i;j<n-1;j++){
                sum += arr[j];
                if(sum <= k){
                    maxLen = Math.max(maxLen,j-i+1);
                }
                else if(sum > k) break;
            }
        }
        return maxLen;
    }
    // Time complexity: O(2n)
    // Space complexity: O(1)
    // Approach: Sliding window
    public static int maxLenSubarryI(int arr[],int k){
        int n = arr.length;
        int maxLen = 0;
        int l = 0,r = 0,sum = 0;
        while(r<n){
            sum += arr[r];
            while(sum > k){
                sum -= arr[l];
                l = l+1;
            }
            if(sum <= k){
                maxLen = Math.max(maxLen,r-l+1);
            }
            r += 1;
        }
        return maxLen;
    }
    // Time complexity: O(n)
    // Space complexity: O(1)
    // Approach: Sliding window
    public static int maxLenSubarryII(int arr[],int k){
        int n = arr.length;
        int maxLen = 0;
        int l = 0,r = 0,sum = 0;
        while(r<n){
            sum += arr[r];
            if(sum > k){
                sum -= arr[l];
                l = l+1;
            }
            if(sum <= k){
                maxLen = Math.max(maxLen,r-l+1);
            }
            r += 1;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,5,6,7};
        int k = 15;
        System.out.println(maxLenSubarry(arr, k));
        System.out.println(maxLenSubarryI(arr, k));
        System.out.println(maxLenSubarryII(arr, k));
    }
}
