/*
L.C: 135. Candy

There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
You are giving candies to these children subjected to the following requirements:
Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.

Example 1:
Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.

Example 2:
Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.
 
Constraints:
n == ratings.length
1 <= n <= 2 * 104
0 <= ratings[i] <= 2 * 104
*/

// Time Complexity: O(3n)
// Space Complexity: O(2n)
public class Candy {
    public static int candy(int ratings[]){
        int n = ratings.length;
        int left[] = new int[n];
        int right[] = new int[n];
        left[0] = 1;
        right[n-1] = 1;
        for(int i = 1;i<n;i++){
            if(ratings[i] > ratings[i-1]){
                left[i] = ratings[i-1]+1;
            }
            else{
                left[i] = 1;
            }
        }
        for(int i = n-2;i>=0;i--){
            if(ratings[i] > ratings[i+1]){
                right[i] = right[i+1]+1;
            }
            else{
                right[i] = 1;
            }
        }
        int sum = 0;
        for(int i = 0;i<n;i++){
            sum += Math.max(left[i],right[i]);
        }
        return sum;
    }
    public static void main(String[] args) {
        int ratings[] = {0,2,4,3,2,1,1,3,5,6,4,0,0};
        System.out.println(candy(ratings));
    }
}