import java.util.ArrayList;
import java.util.List;

public class PrimeFactorizationOfNumber {
    public static void smallestPrimeFactor(List<Integer> queries){
        int maxRange = 0;
        for(int query: queries){
            maxRange = Math.max(maxRange,query);
        }
        int spf[] = new int[maxRange+1];
        for(int i = 2;i<=maxRange;i++){
            spf[i] = i;
        }
        for(int i = 2;i*i<=maxRange;i++){
            if(spf[i] == i){
                for(int j = i*i;j<=maxRange;j+= i){
                    if(spf[j] == j){
                        spf[j] = i;
                    }
                }
            }
        }
        for(int i = 0;i<queries.size();i++){
            int n = queries.get(i);
            while(n != 1){
                System.out.print(spf[n]+" ");
                n = n/spf[n];
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        List<Integer> queries = new ArrayList<>();
        queries.add(30);
        queries.add(15);
        queries.add(16);
        smallestPrimeFactor(queries);
    }
}
