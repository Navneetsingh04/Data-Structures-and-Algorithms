// Time Complexity: O(length of Binary String)
// Space Complexity: O(1)
public class BinaryToDecimal {
    public static int binaryToDecimal(String binary){
        int n = binary.length()-1;
        int pow2 = 1;
        int num = 0;
        for(int i = n;i>=0;i--){
            if(binary.charAt(i) == '1'){
                num += pow2;
            }
            pow2 *= 2;
        }
        return num;
    }
    public static void main(String[] args) {
        String binary = "1110";
        System.out.println(binaryToDecimal(binary));
    }
}
