import java.util.Scanner;
public class SetBit {
    public static int setBit(int num,int pos){
        if(pos<1 || pos>32){
            System.out.println("Invalid bit position");
            return num;
        }
        int mask = 1 <<(pos-1);
        int result = num|mask;
        return result;
    }
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num = s.nextInt();
        System.out.print("Enter the the bit positon to set: ");
        int pos = s.nextInt();
        System.out.println("Number with bit at position "+pos+" set to 1: "+setBit(num, pos));
        s.close();
    }
}
