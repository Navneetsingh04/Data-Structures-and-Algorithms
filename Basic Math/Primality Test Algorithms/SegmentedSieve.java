// Time Complexity : O(n * ln(sqrt(n)))
// Auxiliary Space: O(sqrt(n))

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class SegmentedSieve{
	// performing simple sieve and return primes up to sqrt(R)
	public static List<Integer> sieve(int limit){
		int isPrime[] = new int[limit+1];
		List<Integer> primes = new ArrayList<>();

		for(int i = 2;i<=limit;i++){
			isPrime[i] = 1;
		}
		// sieve of eratosthenese
		for(int i = 2;i*i <= limit;i++){
			if(isPrime[i] == 1){
				for(int j = i*i;j<= limit;j += i){
					isPrime[j] = 0;
				}
			}
		}
		// Generating all prime numbers up to sqrt(limit)
		for(int i = 2;i<= limit;i++){
			if(isPrime[i] == 1){
				primes.add(i);
			}
		}
		return primes;
	}

	// segmented sieve between[L,R]

	public static List<Integer> segmentedSieve(int L,int R){
		// step1 : generate all the prime up to sqrt(R) using simple sieve
		int limit = (int)Math.sqrt(R);
		List<Integer> primes = sieve(limit);

		// step 2: create dummy array of size (R-L+1) and mark that with 1
		int dummyArray[] = new int[R-L+1];
		Arrays.fill(dummyArray,1);

		// edge case: when L = 1 mark it  0
		if (L == 1) {
            dummyArray[0] = 0;
        }
		// // step 3: mark all multiple of primes in (L-R) in dummy array
		
		for(int i : primes){
			int firstMultiple = (L/i)*i;
			if(firstMultiple < L){
				firstMultiple += i; 
			}
			for(int j = Math.max(firstMultiple,i*i);j<=R;j += i){
				dummyArray[j-L] = 0;
			}
		}
		// collecting all prime numbers in range(L-R)
		List<Integer> ans = new ArrayList<>();
		for(int i = 0;i<dummyArray.length;i++){
			if(dummyArray[i] == 1){
				ans.add(L+i);
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		int L = 1;
		int R = 10;
		List<Integer> ans = segmentedSieve(L, R);
		System.out.println("Primes in range [" + L + ", " + R + "]: " + ans);

	}
}