import java.util.Scanner;
public class Find_Ith_bit {
    public static int bit(int num,int bitposition){
        return (num >> (bitposition - 1)) & 1;
    }
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num = s.nextInt();
        System.out.print("Enter the bit postion you want to know: ");
        int bitposition = s.nextInt();
        System.out.println("Bit at postion "+bitposition+" is "+bit(num, bitposition));
        s.close();
    }
}
