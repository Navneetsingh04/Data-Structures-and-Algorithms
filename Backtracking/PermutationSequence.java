/*
L.C: 60. Permutation Sequence

The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"
Example 3:

Input: n = 3, k = 1
Output: "123"
 

Constraints:

1 <= n <= 9
1 <= k <= n! 
*/
import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
     public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        // Precompute the factorial of (n-1) and populate the numbers list
        for(int i = 1;i<n;i++){
            fact = fact*i;   // Update factorial value (for (n-1)!)
            numbers.add(i);
        }
        numbers.add(n);   // Add the last number to the list
        String ans = "";
        k = k-1;     // Decrement k to convert it to 0-based index 
        while(true){
            // Append the correct number (k/fact gives the index of the current number)
            ans = ans+numbers.get(k/fact);
            // Remove the used number from the list
            numbers.remove(k/fact);
            // Remove the used number from the list
            if(numbers.isEmpty()){
                break;
            }
            // Update k to the remainder when divided by fact, for next iteration
            k = k%fact;
            // Recalculate factorial for the remaining numbers
            fact = fact/numbers.size();
        }
        return ans;
    }
    public static void main(String[] args) {
        int n = 4;
        int k = 17;
        PermutationSequence obj = new PermutationSequence();
        System.out.println(k+"th Permutation Sequence is : "+obj.getPermutation(n, k));
    }
}
