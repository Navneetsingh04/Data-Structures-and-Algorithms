// Time Complexity: O(limit);
// Space Complexity : O(limit)

import java.util.ArrayList;
import java.util.List;

public class SieveOfAtkin {
    public static List<Integer> sieveOfAtkin(int limit){
        // step 1:  Initialise the sieve array with 0

        int isPrime[] = new int[limit+1];
        List<Integer> primes = new ArrayList<>();

        if(limit >2){
            primes.add(2);
        }
        if(limit > 3){
            primes.add(3);
        }

        // Step 2: Use the Sieve of Atkin rules
        /*
        Mark isPrime[n] as 1 if one of the following conditions holds:
        a) n = (4 *x^2)+(y^2) and n%12 == 1 or n % 12 == 5
        b) n = (3 * x^2) + (y^2) and n % 12 == 7
        c) n = (3 * x^2) - (y^2) and n % 12 == 11 (x > y)
        */

        for(int x = 1;x*x <= limit;x++){
            for(int y = 1;y*y <= limit;y++){
                // condition 1: n = (4x^2 + y^2)
                int n = (4*x*x)+(y*y);
                if(n <= limit && (n%12 == 1 || n%12 == 5)){
                    isPrime[n] ^= 1; // Toggle the boolean
                }
                // condition 2: n = (3x^2 + y^2)
                n = (3*x*x)+(y*y);
                if(n <= limit && n%12 == 7){
                    isPrime[n] ^= 1;
                }
                // condition 3: n = (3x^2 - y^2)
                if(x>y){
                    n = (3*x*x)-(y*y);
                    if(n <= limit && n%12 == 11){
                        isPrime[n] ^= 1;
                    }
                }
            } 
        }

        // Step 3: Mark multiples of squares of primes as non-prime
        for(int r = 5;r*r<=limit;r++){
            if(isPrime[r] == 1){
                for(int i  = r*r;i<= limit;i += r*r){
                    isPrime[i] = 0;
                }
            }
        }
        // Step 4: Collect primes into the list
        for(int a = 5;a<= limit;a++){
            if(isPrime[a] == 1){
                primes.add(a);
            }
        }
        return primes;
    }
    public static void main(String[] args) {
        int limit = 20;
        List<Integer> primes = sieveOfAtkin(limit);
        System.out.println("Primes up to " + limit + ": " + primes);
    }
}
