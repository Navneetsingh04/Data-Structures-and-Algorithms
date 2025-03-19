import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PrintLIS {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        int hash[] =  new int[n];
        Arrays.fill(dp,1);
        for (int i = 0; i < n; i++) {
            hash[i] = i;
        }
        int maxi = 1;
        int lastIndex = 0;
        for(int i = 0;i<n;i++){
            for(int prev = 0;prev<i;prev++){
                if(nums[prev] < nums[i]){ 
                    dp[i] = 1+dp[prev];
                    hash[i] = prev;
                }
            }
            if(dp[i] > maxi){
                maxi = dp[i];
                lastIndex = i;
            }
        }
        List<Integer> lis = new ArrayList<>();
        lis.add(nums[lastIndex]);
        while(hash[lastIndex] != lastIndex){
            lastIndex = hash[lastIndex];
            lis.add(nums[lastIndex]);
        }
        Collections.reverse(lis);
        System.out.println(lis);
        return maxi;
    }
    public static void main(String[] args) {
        int nums[] = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
}
