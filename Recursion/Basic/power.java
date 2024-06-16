public class power {
    public static int pow(int n){
        if(n == 0){
            return 1;
        }
        return 2*pow(n-1);
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(pow(n));
    }
}
