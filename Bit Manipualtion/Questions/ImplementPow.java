public class ImplementPow {
    public static double power(double b, int e) {
        long exponent = e;
        if(exponent<0){
            exponent = -exponent;
            return 1.0/findPower(b,exponent);
        }
        else{
            return findPower(b,exponent);
        }
        
    }
    public static double findPower(double b,long e){
        double ans = 1.0;
        while(e>0){
            if((e&1) == 1){
                ans *= b;
            }
            b *= b;
            e = e>>1;
        }
        return ans;
    }
    public static void main(String[] args) {
        double b = -0.67000;
        int e =-7;
        System.out.println(power(b, e));
    }
}
