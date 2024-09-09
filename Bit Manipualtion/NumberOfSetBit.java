public class NumberOfSetBit {
    // public static int countSetBit(int n){
    //     int count = 0;
    //     while(n>0){
    //         if((n&1)==1){
    //             count++;
    //         }
    //         n = n >> 1;
    //     }
    //     return count;
    // }
    public static int countSetBit(int n){
        int count = 0;
        while(n != 0){
            n = n&n-1;
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        int n = 9;
        System.out.println(Integer.toBinaryString(n));
        System.out.println("Number of set bits is: " + countSetBit(n));
    }
}
