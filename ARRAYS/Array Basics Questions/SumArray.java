/*
Add two numbers represented by two arrays
EasyAccuracy: 41.78%Submissions: 18K+Points: 2
Given two array A[0….N-1] and B[0….M-1] of size N and M respectively, representing two numbers such that every element of arrays represent a digit. For example, A[] = { 1, 2, 3} and B[] = { 2, 1, 4 } represent 123 and 214 respectively. The task is to find the sum of both the numbers.

Example 1:

Input : A[] = {1, 2}, B[] = {2, 1}
Output : 33
Explanation:
N=2, and A[]={1,2}
M=2, and B[]={2,1}
Number represented by first array is 12.
Number represented by second array is 21
Sum=12+21=33

Example 2:

Input : A[] = {9, 5, 4, 9}, B[] = {2, 1, 4} 
Output : 9763 

 */

import java.util.ArrayList;
import java.util.Collections;
public class SumArray {
    public static ArrayList<Integer> sumArray(int A[],int B[]){
        int i = A.length-1;
        int j = B.length-1;
        int carry = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while(i>=0 && j>=0){
            int x = A[i]+B[j]+carry;
            int digit = x%10;
            ans.add(digit);
            carry = x/10;
            i--;
            j--;
        }
        while(i>=0){
            int x = A[i]+0+carry;
            int digit = x%10;
            ans.add(digit);
            carry = x/10;
            i--;
        }
        while(j>=0){
            int x = 0+B[j]+carry;
            int digit = x%10;
            ans.add(digit);
            carry = x/10;
            j--;
        }
        if(carry != 0){
            ans.add(0,carry);
        }
        Collections.reverse(ans);
        return ans;

    }
    public static void main(String[] args) {
        int A[] = new int[]{9, 5, 4, 9};
        int B[] = new int[]{2, 1, 4,7,8};
        ArrayList<Integer> result = (sumArray(A, B));
        System.out.println(result);
    }
}
