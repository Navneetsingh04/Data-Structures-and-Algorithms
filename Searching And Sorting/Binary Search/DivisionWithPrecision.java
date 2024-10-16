// Time complexity: O(log(dividend))

public class DivisionWithPrecision {
    public static int getQuotient(int dividend,int divisor){
        // Finding the integer part
        int s = 0;
        int end = dividend;
        int ans = -1;
        while(s<=end){
            int mid = s+(end-s)/2;
            if(mid*divisor == dividend){
                return mid;
            }
            else if(mid*divisor <= dividend){
                ans = mid;
                s = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return ans;
    }
    public static double precisionPart(int dividend,int divisor){
        // handling if divisor is 0
        if(divisor==0){
            return 0;
        }
        double store = getQuotient(dividend, divisor);
        double step = 0.1;
        double precision = 5;
        for(int i = 0;i<precision;i++){
            double j = store;
            while(j*divisor<dividend){
                store = j;
                j += step;
            }
            step /= 10;
        }
        return store;
    }
    public static void main(String args[]){
        int dividend = -11;
        int divisor = 3;
        double result = precisionPart(Math.abs(dividend), Math.abs(divisor));
        // handling +ve and -ve
        if((divisor > 0 && dividend <0 ) ||(divisor<0 && dividend>0)){
            result = 0-result;
        }
        System.out.printf("Divison of "+dividend+" with "+divisor+" is "+"%.5f",result);
    }
}
