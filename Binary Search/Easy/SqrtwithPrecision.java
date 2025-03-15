public class SqrtwithPrecision {
    // finding integer part
    public static int mysqrt(int n){
        int s = 0;
        int end = n;
        int ans = -1;
        while(s<=end){
            int  mid = s+(end-s)/2;
            if(mid*mid == n){
                return mid;
            }
            else if(mid*mid <= n){
                ans =  mid;
                s = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return ans;
    }
    // finding precision part
    public static double sqrtwithPrecision(int n){
        double sqrt = mysqrt(n);
        double step = 0.1;
        int precision = 5;
        for(int i = 0;i<precision;i++){
            double j = sqrt;
            while(j*j<=n){
                sqrt = j;
                j += step;
            }
            step = step/10;
        }
        return sqrt;
    }
    public static void main(String[] args) {
        int num = 51;
        double result = sqrtwithPrecision(num);
        System.out.printf("Square Root of  "+num +" is "+"%.5f",result);
    }
}
