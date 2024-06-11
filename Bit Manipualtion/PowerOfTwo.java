public class PowerOfTwo {
    public static void main(String[] args) {
        int n = 56;
        if(n==0){
            System.out.println("false");;
        }
        boolean ans = (n&(n-1)) ==0;
        System.out.println("Power of two or not: "+ans);
    }
}
