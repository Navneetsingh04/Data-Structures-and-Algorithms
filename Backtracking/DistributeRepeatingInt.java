/*
L.C: 1655. Distribute Repeating Integers

You are given an array of n integers, nums, where there are at most 50 unique values in the array. You are also given an array of m customer order quantities, quantity, where quantity[i] is the amount of integers the ith customer ordered. Determine if it is possible to distribute nums such that:

-> The ith customer gets exactly quantity[i] integers,
-> The integers the ith customer gets are all equal, and
-> Every customer is satisfied.
Return true if it is possible to distribute nums according to the above conditions.

Example 1:
Input: nums = [1,2,3,4], quantity = [2]
Output: false
Explanation: The 0th customer cannot be given two different integers.

Example 2:
Input: nums = [1,2,3,3], quantity = [2]
Output: true
Explanation: The 0th customer is given [3,3]. The integers [1,2] are not used.

Example 3:
Input: nums = [1,1,2,2], quantity = [2,2]
Output: true
Explanation: The 0th customer is given [1,1], and the 1st customer is given [2,2].
 
Constraints:
n == nums.length
1 <= n <= 105
1 <= nums[i] <= 1000
m == quantity.length
1 <= m <= 10
1 <= quantity[i] <= 105
There are at most 50 unique values in nums.
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class DistributeRepeatingInt {
    public static boolean canDistributeHelpher(List<Integer> counts,int quantity[],
    int ithCustomer){
        if(ithCustomer == quantity.length){
            return true;
        }
        for(int i = 0;i<counts.size();i++){
            if(counts.get(i) >= quantity[ithCustomer]){
                counts.set(i,counts.get(i)-quantity[ithCustomer]);
                if(canDistributeHelpher(counts,quantity,ithCustomer+1)){
                    return true;
                }
                // backtrack
                counts.set(i,counts.get(i)-quantity[ithCustomer]);
            }
        }
        return false;
    }
    public static boolean canDistribute(int[] nums, int[] quantity) {
        // counting the frequency of each number
        HashMap<Integer,Integer> countMap = new HashMap<>();
        for(int num:nums){
            countMap.put(num,countMap.getOrDefault(num,0)+1);
            }
            // creating a list of counts from the frequency map
            List<Integer> counts = new ArrayList<>();
            for(Map.Entry<Integer,Integer> entry: countMap.entrySet()){
                counts.add(entry.getValue());
            }
            // Sort the quantity array in descending order
            Arrays.sort(quantity);
            int j = quantity.length-1;
            for(int i = 0;i<j;i++,j--){
                int temp = quantity[i];
                quantity[i] = quantity[j];
                quantity[j] = temp;
            }
            return canDistributeHelpher(counts,quantity,0);
        }
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,3};
        int quantity[] = new int[]{2};
        System.out.println(canDistribute(arr, quantity));
    }
}