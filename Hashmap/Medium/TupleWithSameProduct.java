/*
L.C: 1726. Tuple with Same Product

Given an array nums of distinct positive integers, return the number of tuples (a, b, c, d) such that a * b = c * d where a, b, c, and d are elements of nums, and a != b != c != d.

Example 1:
Input: nums = [2,3,4,6]
Output: 8
Explanation: There are 8 valid tuples:
(2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
(3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)

Example 2:
Input: nums = [1,2,4,5,10]
Output: 16
Explanation: There are 16 valid tuples:
(1,10,2,5) , (1,10,5,2) , (10,1,2,5) , (10,1,5,2)
(2,5,1,10) , (2,5,10,1) , (5,2,1,10) , (5,2,10,1)
(2,10,4,5) , (2,10,5,4) , (10,2,4,5) , (10,2,5,4)
(4,5,2,10) , (4,5,10,2) , (5,4,2,10) , (5,4,10,2)
 
Constraints:
1 <= nums.length <= 1000
1 <= nums[i] <= 104
All elements in nums are distinct.
*/

import java.util.HashMap;
import java.util.Map;

public class TupleWithSameProduct {
    public static int tupleSameProduct(int nums[]){
        int n = nums.length;
        int countTuple = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                int product = nums[i]*nums[j];
                map.put(product,map.getOrDefault(product, 0)+1);
            }
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int freq = entry.getValue();
            if(freq > 1){
                countTuple += (freq*(freq-1))/2;
            }
        }
        return countTuple*8;
    }
    public static void main(String[] args) {
        int nums[] = {2,3,4,6};
        System.out.println(tupleSameProduct(nums));
    }
}
