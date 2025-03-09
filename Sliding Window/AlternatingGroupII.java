/*
L.C: 3208. Alternating Groups II

There is a circle of red and blue tiles. You are given an array of integers colors and an integer k. The color of tile i is represented by colors[i]:

colors[i] == 0 means that tile i is red.
colors[i] == 1 means that tile i is blue.
An alternating group is every k contiguous tiles in the circle with alternating colors (each tile in the group except the first and last one has a different color from its left and right tiles).

Return the number of alternating groups.

Note that since colors represents a circle, the first and the last tiles are considered to be next to each other.

Example 1:
Input: colors = [0,1,0,1,0], k = 3
Output: 3
Explanation: The groups are [0,1,0], [1,0,1], [0,1,0].

Example 2:
Input: colors = [0,1,0,0,1,0,1], k = 6
Output: 2
Explanation: The groups are [0,1,0,0,1,0] and [1,0,1,0,1,0].

Example 3:
Input: colors = [1,1,0,1], k = 4
Output: 0
Explanation: There are no alternating groups.

Constraints:
3 <= colors.length <= 105
0 <= colors[i] <= 1
3 <= k <= colors.length 
*/
public class AlternatingGroupII {

    // Approach 1: Brute Force
    // time complexity: O(n*k)
    // space complexity: O(1)

    public static int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int count = 0;

        for(int i = 0;i<n;i++){
            boolean isAlternating = true;
            for(int j = 0;j<k-1;j++){
                if(colors[(i+j)%n] == colors[(i+j+1)%n]){
                    isAlternating = false;
                    break;
                }
            }
            if(isAlternating){
                count++; 
            }
        }
        return count;
    }

    // Approach 2: Sliding Window
    // time complexity: O(N)
    // space complexity: O(1)

    public static int numberOfAlternatingGroupsI(int[] colors, int k) {
        int n = colors.length;
        int count = 0;
        int N = n+(k-1);

        int[] extendedColors = new int[N];
        for(int i = 0; i < n; i++){
            extendedColors[i] = colors[i];
        }
        for(int i = 0; i < k - 1; i++){
            extendedColors[n + i] = colors[i];
        }
        int i = 0,j = 1;
        while(j<N){
            if(extendedColors[j] == extendedColors[j-1]){
                i = j;
                j++;
                continue;
            }
            if(j-i+1 == k){
                count++;
                i++;
            }
            j++;
        }
        return count;
    }

    // Approach 3: Sliding Window (modular arithmetic)
    // time complexity: O(n)
    // space complexity: O(1)

    public static int numberOfAlternatingGroupsII(int[] colors, int k) {
        int n = colors.length;
        int count = 0;

        int i = 0,j = 1;
        while(j<n+(k-1)){
            if(colors[j%n] == colors[(j-1)%n]){
                i = j;
                j++;
                continue;
            }
            if(j-i+1 == k){
                count++;
                i++;
            }
            j++;
        }
        return count;
    }
    public static void main(String[] args) {
        int colors[] = {0,1,0,1,0};
        int k = 3;
        System.out.println(numberOfAlternatingGroups(colors,k));
        System.out.println(numberOfAlternatingGroupsI(colors,k));
        System.out.println(numberOfAlternatingGroupsII(colors,k));
    }
}
