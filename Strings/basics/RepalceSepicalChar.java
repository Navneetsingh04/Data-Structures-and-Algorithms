public class RepalceSepicalChar {
    static String repalceSepicalChar(String str){
        char[] ch = str.toCharArray();
        int n = str.length();
        int i = 0;
        while(i<n){
            if(ch[i] == '@'){
                ch[i] = ' ';
            }
            i++;
        }
        return new String(ch);
    }
    public static void main(String[] args) {
        String str = "NA@@@vn@@ee@@t";
        System.out.println(str.replace("@", ""));
        String result = repalceSepicalChar(str);
        System.out.println("After removing @ with ' ' : "+result);
    }
}
