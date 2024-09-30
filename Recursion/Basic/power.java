public class power {
    public static int pow(int x,int n){
        if(n == 0){
            return 1;
        }
        return x*pow(x,n-1);
    }
    public static void main(String[] args) {
        int x = 5;
        int n = 3;
        System.out.println(pow(x,n));
    }
}
