import java.util.Scanner;
public class PerfectNumber{
    public static boolean isPerfectNumber(int num){
        if(num<=1){
            return false;
        }
        int sum = 1;
        for(int i = 2;i<=Math.sqrt(num);i++){
            if(num%i == 0){
                sum += i;
                if(i != num/i){
                    sum += num/i;
                }
            }
        }
        return sum == num;
    }
    public static void main(String  args[]){
        Scanner s = new Scanner(System.in);
        //perfect Number :  6,28,496,12
        
        System.out.print("Enter th number: ");
        int num = s.nextInt();
        boolean ans = isPerfectNumber(num);
        if(ans){
            System.out.println(ans+" is a perfect number");
        }
        else{
            System.out.println(ans+" is a not perfect number");
        }
        s.close();
    }
}