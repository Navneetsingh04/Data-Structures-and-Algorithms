import java.util.Scanner;
public class ResetBit {
    public static int resetBit(int num,int pos){
        if(pos<1 || pos>32){
            System.out.println("Invalid bit position");
            return num;
        }
        int mask = 1 <<(pos-1);
        int result = num&(~mask);
        return result;
    }
    public static void main(String args[]){
        try (Scanner s = new Scanner(System.in)) {
            System.out.print("Enter the number: ");
            int num = s.nextInt();
            System.out.print("Enter the the bit positon to set: ");
            int pos = s.nextInt();
            System.out.println("Number with bit at position "+pos+" Reset to 0: "+resetBit(num, pos));
        }
    }
}
