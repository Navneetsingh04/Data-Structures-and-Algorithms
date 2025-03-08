/*
L.C: 632. Smallest Range Covering Elements from K Lists

You have k lists of sorted integers in non-decreasing order. Find the smallest range that includes at least one number from each of the k lists.

We define the range [a, b] is smaller than range [c, d] if b - a < d - c or a < c if b - a == d - c.

Example 1:
Input: nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
Output: [20,24]
Explanation: 
List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
List 2: [0, 9, 12, 20], 20 is in range [20,24].
List 3: [5, 18, 22, 30], 22 is in range [20,24].

Example 2:
Input: nums = [[1,2,3],[1,2,3],[1,2,3]]
Output: [1,1]
 
Constraints:
nums.length == k
1 <= k <= 3500
1 <= nums[i].length <= 50
-105 <= nums[i][j] <= 105
nums[i] is sorted in non-decreasing order.
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestRangeCoveringElementsFromkLists {
    static class Info{
        int data;  
        int arrayIndex; // index of the array 
        int elementIndex; // index of the element in the array
        Info(int data,int arrayIndex,int elementIndex){
            this.data = data;
            this.arrayIndex = arrayIndex;
            this.elementIndex = elementIndex;
        }
    }
    public static int[] smallestRange(List<List<Integer>> nums) {
        // PriorityQueue<Info> pq = new PriorityQueue<>(new Comparator<Info>(){
        //     public int compare(Info a,Info b){
        //         return a.data - b.data;
        //     }
        // });
        PriorityQueue<Info> pq = new PriorityQueue<>((Info a, Info b) -> a.data - b.data);
        int maxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;
        for(int i = 0;i<nums.size();i++){
            int element = nums.get(i).get(0);
            int row = i;
            int col = 0;
            Info temp = new Info(element,row,col);
            pq.add(temp);
            maxi = Math.max(maxi,element);
            mini = Math.min(mini,element);
        }
        int ansStart = mini;
        int ansEnd = maxi;

        while(!pq.isEmpty()){
            Info topNode = pq.peek();
            // int topData = topNode.data;
            int topCol = topNode.elementIndex;
            int topRow = topNode.arrayIndex;
            pq.poll();

            mini = topNode.data;

            if((maxi-mini)< (ansEnd-ansStart)){
                ansStart = mini;
                ansEnd = maxi;
            }
            // insertion
            if(topCol +1 <nums.get(topRow).size()){
                int newElement = nums.get(topRow).get(topCol+1);
                maxi = Math.max(maxi,newElement);
                Info newInfo = new Info(newElement,topRow,topCol+1);
                pq.add(newInfo);
            }
            // There no elment left;
            else{
                break;
            }
        }
        int ans[] = new int[2];
        ans[0] = ansStart;
        ans[1] = ansEnd;
        return ans;

    }
    public static void main(String[] args) {
        // int nums[][] = {{4,10,15,24,26},{0,9,12,20},{5,18,22,30}};
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(4, 10, 15, 24, 26));
        nums.add(Arrays.asList(0, 9, 12, 20));
        nums.add(Arrays.asList(5, 18, 22, 30));

        int ans[] = smallestRange(nums);
        System.out.println("Smallest Range: ["+ans[0]+","+ans[1]+"]");

    }
}
