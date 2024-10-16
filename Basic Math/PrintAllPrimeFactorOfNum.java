
import java.util.ArrayList;
import java.util.List;

public class PrintAllPrimeFactorOfNum {
    // Brute force

    // public static boolean  isPrime(int n){
    //     if(n<=1){
    //         return false;
    //     }
    //     for(int i = 2;i*i<=n;i++){
    //         if(n%i == 0){
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    // public static List<Integer> primefactors(int n){
    //     List<Integer> list = new ArrayList<>();
    //     for(int i = 1;i*i<=n;i++){
    //         if(n%i == 0){
    //             if(isPrime(i)){
    //                 list.add(i);
    //             }
    //         }
    //         if((n/i) != i){
    //             if(isPrime(n/i))
    //             list.add(n/i);
    //         } 
    //     }
    //     return list;
    // }

    // optimal 
    // Time complexity: O(sqrt(n)*logn)

    public static List<Integer> primefactors(int n){
        List<Integer> list = new ArrayList<>();
        for(int i = 2;i*i<n;i++){
            if(n%i == 0){
                list.add(i);
            }
            while(n%i == 0){
                n = n/i;
            }
        }
        if(n != 1){
            list.add(n);
        }
        return  list;
    }
    public static void main(String[] args) {
        int n = 60;
        List<Integer> ans = primefactors(n);
        System.out.println(ans);
    }
}
