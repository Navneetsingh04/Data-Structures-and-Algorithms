/*
Count Derangements (Permutation such that no element appears in its original position)
Last Updated : 20 Jul, 2022
A Derangement is a permutation of n elements, such that no element appears in its original position. For example, a derangement of {0, 1, 2, 3} is {2, 3, 1, 0}.
Given a number n, find the total number of Derangements of a set of n elements.

Examples : 

Input: n = 2
Output: 1
For two elements say {0, 1}, there is only one 
possible derangement {1, 0}

Input: n = 3
Output: 2
For three elements say {0, 1, 2}, there are two 
possible derangements {2, 0, 1} and {1, 2, 0}
 */
public class CountDearregment {
    public static int count(int n){
        if(n == 1){
            return 0;
        }
        if(n == 2){
            return 1;
        }
        int ans = (n-1)*(count(n-1)+count(n-2));
        return ans;

    }
    public static void main(String[] args) {
        int n = 3;
        System.out.println(count(n));
    }
}
