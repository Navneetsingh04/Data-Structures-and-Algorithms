public class NumberOfSetBit {
    public static void main(String[] args) {
        int n = 9;
        int count = 0;
        while(n>0){
            if((n&1)==1){
                count++;
            }
            n = n >> 1;
        }
        System.out.println(Integer.toBinaryString(9));
        System.out.println("Number of set bits is: " + count);
    }
}
