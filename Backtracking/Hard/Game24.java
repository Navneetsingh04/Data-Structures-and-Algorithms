/*
L.C: 679. 24 Game

You are given an integer array cards of length 4. You have four cards, each containing a number in the range [1, 9]. You should arrange the numbers on these cards in a mathematical expression using the operators ['+', '-', '*', '/'] and the parentheses '(' and ')' to get the value 24.

You are restricted with the following rules:

The division operator '/' represents real division, not integer division.
For example, 4 / (1 - 2 / 3) = 4 / (1 / 3) = 12.
Every operation done is between two numbers. In particular, we cannot use '-' as a unary operator.
For example, if cards = [1, 1, 1, 1], the expression "-1 - 1 - 1 - 1" is not allowed.
You cannot concatenate numbers together
For example, if cards = [1, 2, 1, 2], the expression "12 + 12" is not valid.
Return true if you can get such expression that evaluates to 24, and false otherwise.

Example 1:

Input: cards = [4,1,8,7]
Output: true
Explanation: (8-4) * (7-1) = 24
Example 2:

Input: cards = [1,2,1,2]
Output: false
 
Constraints:
cards.length == 4
1 <= cards[i] <= 9 
*/
import java.lang.Math;
import java.util.ArrayList;
import java.util.List;
public class Game24 {
    static double epsilon = 0.1;
    private static boolean solve(double cards[]){
        if(cards.length == 1){
            return Math.abs(cards[0]-24) <=  epsilon;
        }

        for(int i = 0;i<cards.length;i++){
            for(int j= 0;j<cards.length;j++){
                if(i == j) continue;
                List<Double> temp = new ArrayList<>();
                for(int k = 0;k<cards.length;k++){
                    if(k != i && k != j){
                        temp.add(cards[k]);
                    }
                }
                double a = cards[i];
                double b = cards[j];

                List<Double> possibleVal = new ArrayList<>();
                possibleVal.add(a+b);
                possibleVal.add(a-b);
                possibleVal.add(b-a);
                possibleVal.add(a*b);

                if(Math.abs(b) > 0.0){
                    possibleVal.add(a/b);
                }
                if(Math.abs(a) > 0.0){
                    possibleVal.add(b/a);
                }

                for(double val : possibleVal){
                    temp.add(val);
                    double next[] = new double[temp.size()];
                    for(int k = 0;k<temp.size();k++){
                        next[k] = temp.get(k);
                    }
                    if(solve(next)) return true;
                    temp.remove(temp.size()-1);
                }
            }
        }
        return false;
    }
    public static boolean judgePoint24(int cards[]){
        int n = cards.length;
        double[] nums = new double[n];
        for(int i = 0;i<n;i++){
            nums[i] = (1.0*cards[i]);
        }
        return solve(nums);
    }
    public static void main(String[] args) {
        int cards[] = {4,1,8,7};
        System.out.println(judgePoint24(cards));
    }
}
