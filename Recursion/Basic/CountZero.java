import java.util.Scanner;
public class CountZero {
    public static int count(int num){
        if(num == 0){
            return 0;
        }
        int rem = num%10;
        int cnt = count(num/10);;
        if(rem == 0){
            cnt++;
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num = s.nextInt();
        if(num == 0){
            System.out.println(1);
        }
        else{
        System.out.println(count(num));
        }
        s.close();
    }
}
