public class PermutationOfString {
    public static String swap(String str,int index,int j){
        char[] charArray = str.toCharArray();
        char temp = charArray[index];
        charArray[index] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
    public static void printPermutation(String str,int index){
        if(index >= str.length()){
            System.out.print(str+" ");
            return;
        }
        for(int j = index;j<str.length();j++){
            // Swap the characters at index and j
            str = swap(str, index, j);
            printPermutation(str, index+1);
            // backtracking
            str = swap(str,index,j);
        }
    }
    public static void main(String[] args) {
        String str = "ABC";
        System.out.print("Permutation of String is: ");
        printPermutation(str, 0);
    }
}
