public class Palindrome{
    public static boolean palindrome(String str,int s,int e){
        if(s>=e){
            return true;
        }
        if(str.charAt(s) != str.charAt(e)){
            return false;
        }
        return palindrome(str, s+1, e-1);
    }
    public static void main(String[] args) {
        String str = "r";
        int s = 0;
        int e = str.length()-1;
        boolean result = palindrome(str, s, e);
        if(result){
            System.out.println(str+" is a palindrome");
        }
        else{
            System.out.println(str+" is not palindromic String");
        }
    }
}
