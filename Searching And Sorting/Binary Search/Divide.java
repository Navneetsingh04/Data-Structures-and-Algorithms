/*
Given two integers, dividend and divisor, implement a function to divide dividend by divisor using binary search.
*/

// Time complexity : O(logdividend)

public class Divide {
    public static int getQuotient(int divisor,int dividend){
        int s = 0;
        int end = dividend;
        int ans = -1;
        if(divisor == 0){
            return 0;
        }
        while(s<=end){
            int mid = s+(end-s)/2;
            if(mid*divisor == dividend){
                return mid;
            }
            else if(mid*divisor<=dividend){
                // store ans
                ans = mid;
                s = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return ans;
    }
    public static void main(String args[]){
        int divisor = 0;
        int dividend = 35;
        int ans = getQuotient(Math.abs(divisor),Math.abs(dividend));
        // sign +ve or -ve
        if((divisor >0 && dividend<0) || (divisor>0 && dividend<0)){
            ans = 0 - ans;
        }
        System.out.println("Final ans: "+ans);
    }
}
