/*
Calculate XOR from 1 to n.

Given a number n, the task is to find the XOR from 1 to n. 
Examples : 

Input : n = 6
Output : 7
// 1 ^ 2 ^ 3 ^ 4 ^ 5 ^ 6 = 7

Input : n = 7
Output : 0
// 1 ^ 2 ^ 3 ^ 4 ^ 5 ^ 6 ^ 7 = 0
*/
public class FindXOR {
    // public static int findXor(int n){
    //     int ans = 0;
    //     for(int i = 1;i<=n;i++){
    //         ans = ans^i;
    //     }
    //     return ans;
    // }
    public static int findXor(int n){
        switch (n%4) {
            case 0:
                return 1;
            case 2:
                return n+1;
            case 3:
                return 0;
            default:
                return n;
        }
    }
    public static void main(String[] args) {
        int n = 6;
        System.out.println(findXor(n));
    }
}
