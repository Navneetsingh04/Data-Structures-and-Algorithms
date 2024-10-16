import java.util.Scanner;
public class CheckPrime {
    // public static boolean isPrime(int num){
    //     if(num<=1){
    //         return false;
    //     }
    //     for(int i = 2;i*i<=num;i++){
    //         if(num%i == 0){
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    public static boolean isPrime(int n){
        if(n<=1) return false;
        if(n<=3) return true;
        if(n%2 == 0 || n%3 == 0) return false;
        for(int i = 5;i*i<=n;i += 6){
            if(n%i == 0 || n%(i+2) == 0) return false;
        }
        return true;
    } 
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num = s.nextInt();
        boolean result = isPrime(num);
        if(result){
            System.out.println(num +" is prime Number");
        }
        else{
            System.out.println(num+" is not a prime Number");
        }
        s.close();
    }
}
