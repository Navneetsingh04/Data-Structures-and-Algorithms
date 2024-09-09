public class PowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        if(n <= 0){
            return false;
        }
        if((n&(n-1)) == 0){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int n = 56;
        boolean ans = isPowerOfTwo(n);
        System.out.println(n+" is Power of two or not: "+ans);
    }
}
