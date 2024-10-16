import java.util.Scanner;
public class ToggleBit {
    public static int toggleBit(int n,int i){
        int mask = (1<<i);
        return n^mask;
    }
    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            System.out.print("Enter the number: ");
            int num = s.nextInt();
            System.out.print("Enter the the bit positon to toggle: ");
            int pos = s.nextInt();
            System.out.println("Number with bit at position "+pos+" toggle then it is: "+ toggleBit(num, pos));
        }
    }
}
