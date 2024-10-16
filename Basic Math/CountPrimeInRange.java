import java.util.Arrays;
public class CountPrimeInRange{
    public static int[] getSieve(int n){
        int prime[] = new int[n+1];
        Arrays.fill(prime, 1);
        prime[0] = 0;  
        prime[1] = 0;
        for(int i = 2;i*i<=n;i++){
            if(prime[i] == 1){
                for(int j = i*i;j<=n;j += i){
                    prime[j] = 0;
                }
            }
        }
        for(int i = 1;i <= n;i++){
            prime[i] += prime[i-1];
        }
        return prime;
    }
    public static int countPrime(int l,int r){
       int[] sieve = getSieve(r);
       if(l <= 1) l = 2;
       return sieve[r]-sieve[l-1];
    }
    public static void main(String args[]){
        int l = 5;
        int r = 100;
        System.out.println(countPrime(l, r));
    }

}