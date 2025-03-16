/*
L.C: 2594. Minimum Time to Repair Cars

You are given an integer array ranks representing the ranks of some mechanics. ranksi is the rank of the ith mechanic. A mechanic with a rank r can repair n cars in r * n2 minutes.

You are also given an integer cars representing the total number of cars waiting in the garage to be repaired.
Return the minimum time taken to repair all the cars.

Note: All the mechanics can repair the cars simultaneously.

Example 1:
Input: ranks = [4,2,3,1], cars = 10
Output: 16
Explanation: 
- The first mechanic will repair two cars. The time required is 4 * 2 * 2 = 16 minutes.
- The second mechanic will repair two cars. The time required is 2 * 2 * 2 = 8 minutes.
- The third mechanic will repair two cars. The time required is 3 * 2 * 2 = 12 minutes.
- The fourth mechanic will repair four cars. The time required is 1 * 4 * 4 = 16 minutes.
It can be proved that the cars cannot be repaired in less than 16 minutes.​​​​​

Example 2:

Input: ranks = [5,1,8], cars = 6
Output: 16
Explanation: 
- The first mechanic will repair one car. The time required is 5 * 1 * 1 = 5 minutes.
- The second mechanic will repair four cars. The time required is 1 * 4 * 4 = 16 minutes.
- The third mechanic will repair one car. The time required is 8 * 1 * 1 = 8 minutes.
It can be proved that the cars cannot be repaired in less than 16 minutes.​​​​​
 
Constraints:

1 <= ranks.length <= 105
1 <= ranks[i] <= 100
1 <= cars <= 106 
*/

// T.C: O(n * log(maxRank*cars*cars))

public class MinTimeToRepairCars {
    public static long repairCars(int[] ranks, int cars) {
        int maxRank = Integer.MIN_VALUE;
        for(int num : ranks){
            maxRank = Math.max(maxRank,num);
        }
        long l = 1;
        long r = (long)maxRank*cars*cars;
        long ans = -1;

        while(l<=r){
            long mid = l+(r-l)/2;
            if(isPossible(ranks,mid,cars)){
                ans = mid;
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return ans;
    }
    public static boolean isPossible(int ranks[],long mid,int cars){
        long carFix = 0;
        for(int i = 0;i<ranks.length;i++){
            carFix += (long)Math.sqrt(mid/ranks[i]);
        }
        return carFix >= cars;
    }
    public static void main(String[] args) {
        int ranks[] = {4,2,3,1};
        int cars = 10;
        System.out.println(repairCars(ranks, cars));
    }
}
