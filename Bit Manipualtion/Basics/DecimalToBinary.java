// Time Complexity: O(logn)
// Space Complexity: O(logn)
public class DecimalToBinary {
    public static String convertToBinary(int n){
        StringBuilder res = new StringBuilder();
        while(n > 0){
            if(n%2 == 1){
                res.append("1");
            }
            else{
                res.append("0");
            }
            n = n/2;
        }
       res.reverse();
       return res.toString();
    }
    public static void main(String[] args) {
        int n = 10;
        System.out.println(convertToBinary(n));
    }
}
