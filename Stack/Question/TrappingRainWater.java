/*
L.C: 42. Trapping Rain Water

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9

Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
*/
public class TrappingRainWater {
    public static int trap(int height[]){
        int leftMAx = 0;
        int rightMAx = 0;
        int left = 0;
        int right = height.length-1;
        int total = 0;

        while(left < right){
            if(height[left] <= height[right]){
                if(leftMAx > height[left]){
                    total += leftMAx-height[left];
                }
                else{
                    leftMAx = height[left];
                }
                left++;
            }
            else{
                if(rightMAx > height[right]){
                    total += rightMAx-height[right];
                }
                else{
                    rightMAx = height[right];
                }
                right--;
            }
        }
        return total;
    }
    public static void main(String[] args) {
        int arr[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Toatl Amount of water Trap is: "+trap(arr));
    }
}
