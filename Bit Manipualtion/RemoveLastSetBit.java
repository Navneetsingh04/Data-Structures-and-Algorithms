// Remove last set bit(RightMost)
public class RemoveLastSetBit {
    public static int removeLastSetBit(int n){
        return n&n-1;
    }
    public static void main(String[] args) {
        int n = 83;
        System.out.println(removeLastSetBit(n));
    }
}
