public class PowerOfNumber{
    // Time complexity: O(logn)
    public static Double power(int x,int n){
        int m = n;
        double ans = 1.0;
        n = Math.abs(n);
        while(n>0){
            // if power is odd take x from it ans multiply it into ans
            if(n%2 == 1){
                ans = ans*x;
                n = n-1;
            }
            else{
                n = n/2;
                x = x*x;
            }
        }
        if(m<0){
            return 1.0/ans;
        }
        return ans;
    }
    public static void main(String[] args) {
        int x = 2;
        int n = -2;
        System.out.println(power(x, n));
    }
}
