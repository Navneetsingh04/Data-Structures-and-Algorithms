public class ReverseString {
    public static void reverseString(char str[],int s ,int e){
        if(s>=e){
            return;
        }
        char temp = str[s];
        str[s] = str[e];
        str[e] = temp;
        reverseString(str,s+1,e-1);
    }
    public static void main(String[] args) {
        String str = "Navneet Singh";
        char[] charArray = str.toCharArray();
        int s = 0;
        int e = str.length()-1;
        reverseString(charArray,s,e);
        String reString = new String(charArray);
        System.out.println(reString);
    }
}