/*
L.C: 1980. Find Unique Binary String

Given an array of strings nums containing n unique binary strings each of length n, return a binary string of length n that does not appear in nums. If there are multiple answers, you may return any of them.

Example 1:
Input: nums = ["01","10"]
Output: "11"
Explanation: "11" does not appear in nums. "00" would also be correct.

Example 2:
Input: nums = ["00","01"]
Output: "11"
Explanation: "11" does not appear in nums. "10" would also be correct.

Example 3:
Input: nums = ["111","011","001"]
Output: "101"
Explanation: "101" does not appear in nums. "000", "010", "100", and "110" would also be correct.

Constraints:
n == nums.length
1 <= n <= 16
nums[i].length == n
nums[i] is either '0' or '1'.
All the strings of nums are unique. 
*/

// Time Complexity: O(n^2)
// Space Complexity: O(n)

import java.util.HashSet;
import java.util.Set;
public class FindUniqueBinaryString {
    public static String findDifferentBinaryString(String nums[]){
        int n = nums.length;
        Set<String> set = new HashSet<>();
        for(String str : nums){
            set.add(str);
        }
        return generatedString("",n,set);
    }
    public static String generatedString(String curr,int n,Set<String> set){
        if(curr.length() == n){
            if(!set.contains(curr)){
                return curr;
            }
            return "";
        }
        String zero = generatedString(curr+"0",n,set);
        if(zero.length() > 0){
            return zero;
        }
        return generatedString(curr+"1",n,set);
    }
    public static void main(String[] args) {
        String[] nums = {"01","10"};
        System.out.println(findDifferentBinaryString(nums));
    }
}
