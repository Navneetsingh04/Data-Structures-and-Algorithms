public class ArmstrongNumber {
    public static boolean  armstrongNumber(int n){
        int temp = n;
        int count = 0;
        while(temp > 0){
            count++;
            temp  = temp /10;
        }
        temp = n;
        int armstrong = 0;
        while(temp != 0){
            int digit = temp%10;
            armstrong += (int) Math.pow(digit,count);
            temp = temp/10;
        }
        return  armstrong == n;
    }
    public static void main(String[] args) {
        int n = 34;
        boolean ans = armstrongNumber(n);
        if(ans){
            System.out.println(n+" is a ArmstrongNumber");
        }
        else{
            System.out.println(n+" is not a ArmstrongNumber");
        }
    }
}
