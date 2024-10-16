import java.util.regex.*;
import java.util.Arrays;
public class StringMethods {
    public static void main(String[] args) {
        String st = "Navneet";
        System.out.println("String "+st);
        System.out.println("Length of String: "+st.length());
        System.out.println("LowerCase: "+st.toLowerCase());
        System.out.println("UpperCase: "+st.toUpperCase());
        System.out.println("After removing the Whitespace: "+st.trim()); 
        System.out.println("Substring from the 3rd index: "+st.substring(3));
        System.out.println("Substring from 1 to 6 index"+st.substring(1,6));
        System.out.println("Replace N with M: "+st.replace('N', 'M'));
        System.out.println("is String start with Nav: "+st.startsWith("Nav"));
        System.out.println("is String ends with ne: "+st.endsWith("ne"));
        System.out.println("Char at 2nd index: "+st.charAt(2));
        System.out.println("Index of e: "+st.indexOf("e"));
        System.out.println("Index of e after the 1st index: :"+st.indexOf("e",1));
        System.out.println("Return the last index of e: "+st.lastIndexOf("e"));
        System.out.println("is Navneet equals to st: "+st.equals("Navneet"));
        System.out.println("is navneet equals to st(ignore case): "+st.equalsIgnoreCase("navneet"));
        System.out.println("Char Array of String st: "+Arrays.toString(st.toCharArray()));
        String newst = st;
        newst = newst.replaceAll("[AEIOUaeiou]", "");
        System.out.println(newst);
        System.out.println("Contains Navneet or not: "+st.contains("Navneet"));
        boolean b = Pattern.matches("a*b", "aaaaab");
        System.out.println(b);
    }
}
