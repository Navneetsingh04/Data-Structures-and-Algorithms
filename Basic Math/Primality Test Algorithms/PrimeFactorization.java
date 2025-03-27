public class PrimeFactorization {
    public static void primeFactorization(int n){
        for(int i = 2;i*i<=n;i++){
            while(n%i == 0){
                System.out.print(i+" ");
                n = n/i;
            }
        }
        if(n > 1){
            System.out.print(n+" ");
        }
    }
    public static void main(String[] args) {
        int n = 315;
        primeFactorization(n);
    }
}
