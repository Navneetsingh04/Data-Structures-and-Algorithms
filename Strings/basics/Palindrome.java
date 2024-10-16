// Time Complexity : o(n)

import java.util.Scanner;
public class Palindrome {
    static boolean checkpalindrome(String str){
        String string = str.toLowerCase();
        int n = string.length();
        for(int i= 0;i<n/2;i++){
            if(string.charAt(i) != string.charAt(n-i-1)){
                return false;
            }
    }
    return true;
}
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the String: ");
        String str = s.nextLine();
        boolean result = checkpalindrome(str);
        if(!result){
            System.out.println(str+" is not palindrome String");
        }
        else{
            System.out.println(str +" is palindrome String");
        }
        s.close();
    }
}
