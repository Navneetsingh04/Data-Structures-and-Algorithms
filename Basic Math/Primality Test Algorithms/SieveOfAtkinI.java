import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SieveOfAtkinI {
    public static List<Integer> sieveOfAtkin(int limit){
        boolean sieve[] = new boolean[limit+1];
        Arrays.fill(sieve,false);
        sieve[2] = true;
        sieve[3] = true;
        // Mark sieve[n] as true if one of the following conditions holds:
        // a) n = (4*x^2)+(y^2) and n%12 == 1 or n % 12 == 5    
        // b) n = (3*x^2) + (y^2) and n % 12 == 7
        // c) n = (3*x^2) - (y^2) and n % 12 == 11 (x > y)
        for(int x = 1;x*x<=limit;x++){
            for(int y = 1;y*y<=limit;y++){
                int n = (4*x*x)+(y*y);
                if(n <= limit && (n%12 == 1 || n%12 == 5)){
                    sieve[n] = !sieve[n];
                }

                n = (3*x*x)+(y*y);
                if(n<=limit && n%12 == 7){
                    sieve[n] = !sieve[n];
                }

                n = (3*x*x)-(y*y);
                if(x>y && n<=limit && n%12 == 11){
                    sieve[n] = !sieve[n];
                }
            }
        }
        // Mark all multiples of squares of primes as non-prime
        for(int i = 5;i*i<=limit;i++){
            if(sieve[i]){
                for(int j = i*i;j<=limit;j+=i*i){
                    sieve[j] = false;
                }
            }
        }

        // collect all prime numbers
        List<Integer> primes = new ArrayList<>();
        for(int i = 2;i<=limit;i++){
            if(sieve[i]){
                primes.add(i);
            }
        }
        return primes;
    }
    public static void main(String[] args) {
        int limit = 50;
        List<Integer> primes = sieveOfAtkin(limit);
        System.out.println("Prime number from 2 to "+limit+" is: ");
        System.out.println(primes);
    }
}
