/*
L.C: 670. Maximum Swap

You are given an integer num. You can swap two digits at most once to get the maximum valued number.

Return the maximum valued number you can get.

Example 1:
Input: num = 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.

Example 2:
Input: num = 9973
Output: 9973
Explanation: No swap.

Constraints:
0 <= num <= 108 
*/
public class MaximumSwap {
    // Approach 1: Store maxRight index
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    // public static int maximumSwap(int num){
    //     String s = Integer.toString(num);
    //     int n = s.length();

    //     // Array to store the index of the maximum element to the right
    //     int maxRight[] = new int[n];
    //     maxRight[n-1] = n-1;

    //     for(int i = n-2;i>=0;i--){
    //         int rightMaxIndex = maxRight[i+1];
    //         char rightMaxElement = s.charAt(rightMaxIndex);

    //         // Update maxRight with the index of the maximum element
    //         if(s.charAt(i) > rightMaxElement){
    //             maxRight[i] = i;
    //         }
    //         else{
    //             maxRight[i] = rightMaxIndex;
    //         }
    //     }

    //     // find the first position where swappinng will maximize the number
        
    //     for(int i = 0;i<n;i++){
    //         int maxRightIndex = maxRight[i];
    //         char maxRightElement = s.charAt(maxRightIndex);

    //         // If there is a bigger digit to the right, swap and return the result
    //         if(s.charAt(i) < maxRightElement){
    //             char charArray[] = s.toCharArray();
    //             char temp = charArray[i];
    //             charArray[i] = charArray[maxRightIndex];
    //             charArray[maxRightIndex] = temp;

    //             return Integer.parseInt(new String(charArray));
    //         }
    //     }
    //     return num;
    // }
    // Approach 2: constant Space
    // Time Complexity: O(N)
    // Space Complexity: O(1)

    public static int maximumSwap(int num) {
        String s = Integer.toString(num);
        int n = s.length();

        int maxRight[] = new int[10];
        for(int i = 0;i<10;i++){
            maxRight[i] = -1;
        }

        for(int i = 0;i<n;i++){
            int index = s.charAt(i)-'0';
            maxRight[index] = i;
        }
        // Find the first place to swap to get the largest number
        for(int i = 0;i<n;i++){
            int currDigit = s.charAt(i)-'0';
            // Try to find a larger digit to swap with current one
            for(int digit = 9;digit>currDigit;digit--){
                if(maxRight[digit] > i){
                    // Swap the current digit with the larger one found
                    char[] charArray = s.toCharArray();
                    char temp = charArray[i];
                    charArray[i] = charArray[maxRight[digit]];
                    charArray[maxRight[digit]] = temp;

                    return Integer.parseInt(new String(charArray));
                }
            }
        }
        return num;
    }   
    public static void main(String[] args) {
        int  num = 2736;
        System.out.println(maximumSwap(num));
    }
}
