import java.util.Scanner;
public class ClearBit {
    public static int clearBit(int n,int i){
        int mask = ~(1 << i);  
        return n & mask;
        // return n&(~(1<<i)); 
    }
    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            System.out.print("Enter the number: ");
            int num = s.nextInt();
            System.out.print("Enter the the bit positon to clear: ");
            int pos = s.nextInt();
            System.out.println("Number with bit at position "+pos+" clear then it is: "+clearBit(num, pos));
        }
    }
}
