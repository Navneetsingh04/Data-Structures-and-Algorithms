// time complexity O(n)
import java.util.Scanner;
public class ReverseString {
    static String reverseString(String str){
        int n = str.length();
        char[] ch = str.toCharArray();
        int l = 0,h = n-1;
        while(l<h){
            char temp = ch[l];
            ch[l] = ch[h];
            ch[h] = temp;
            l++;
            h--;
        }
        return new String(ch);
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the String: ");
        String str = s.nextLine();
        System.out.println("String before Reverse: "+str);
        String result = reverseString(str);
        System.out.println("String after Reverse: "+result);
        s.close();
    }
}


