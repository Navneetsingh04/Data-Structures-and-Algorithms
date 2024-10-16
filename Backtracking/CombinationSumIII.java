/*
216. Combination Sum III

Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

Example 1:
Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.

Example 2:
Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.

Example 3:
Input: k = 4, n = 1
Output: []
Explanation: There are no valid combinations.
Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
 
Constraints:
2 <= k <= 9
1 <= n <= 60 
*/
// Time Complexity : O(9^k)
import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public static void findCombination(int index,int k,int n,List<Integer> list, List<List<Integer>> ans){
        if(k == 0 && n == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = index;i<=9;i++){
            if(i > n) break;
            list.add(i);
            findCombination(i+1,k-1,n-i,list,ans);
            list.remove(list.size()-1);
        }
    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        findCombination(1,k,n,list,ans);
        return ans;
    }
    public static void main(String[] args) {
        int k = 3;
        int n = 7;
        List<List<Integer>> ans = combinationSum3(k, n);
        System.out.println(ans);
    }
}
