public class CheckSetBit {
    public static boolean checkSetBit(int n,int i){
        // using left shift
        // return (n&(1<<i)) != 0;

        // using  right shift
        return ((n>>i)&1) != 0;
    }
    public static void main(String[] args) {
        int n = 13;
        int i = 2;
        System.out.println(checkSetBit(n, i));
    }
}
 