import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class PrimeCountInRangeOfQueries{
    public static int[] getSieve(int n){
        int prime[] = new int[n+1];
        Arrays.fill(prime,1);
        prime[0] = 0;
        prime[1] = 0;
        for(int i = 2;i*i<=n;i++){
            if(prime[i] == 1){
                for(int j = i*i;j<=n;j += i){
                    prime[j] = 0;
                }
            }
        }
        return prime;
    }
    public static void countPrime(List<List<Integer>> queries){
        int maxRange = 0;
        for(List<Integer> query : queries){
            maxRange = Math.max(maxRange,query.get(1));
        }
        int prime[] = getSieve(maxRange);
        int count = 0;
        for(int i = 2;i<=maxRange;i++){
            count += prime[i];
            prime[i] = count;
        }
        for(List<Integer> query : queries){
            int l = query.get(0);
            int r = query.get(1);
            System.out.print((prime[r]-prime[l-1])+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        List<List<Integer>> queries = new ArrayList<>();
        queries.add(Arrays.asList(2,10));
        queries.add(Arrays.asList(11,30));
        queries.add(Arrays.asList(5,100));
        countPrime(queries);
    }
}
