/*
L.C: 179. Largest Number
Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.

Since the result may be very large, so you need to return a string instead of an integer.
Example 1:
Input: nums = [10,2]
Output: "210"

Example 2:
Input: nums = [3,30,34,5,9]
Output: "9534330"

Constraints:
1 <= nums.length <= 100
0 <= nums[i] <= 109
 */
import java.util.*;
public class LargestNumber {
    public static String largestNumber(int nums[]){
        List<String> snums = new ArrayList<>();
        for(int n:nums){
            snums.add(Integer.toString(n));
        }
        snums.sort(new Comparator<String>(){
            public int compare(String a,String b){
                String a1 = a+b;
                String b1 = b+a;
                return b1.compareTo(a1);
            }
        });
        StringBuilder ans = new StringBuilder();
        for(String s: snums){
            ans.append(s);
        }
        if(ans.charAt(0) == '0'){
            return "0";
        }
        return ans.toString();
    }
    public static void main(String args[]){
        int arr[] = new int[]{3,30,34,5,9};
        System.out.println("The Largest number is "+largestNumber(arr));
    }
}