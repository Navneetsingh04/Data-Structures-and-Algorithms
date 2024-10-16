import java.util.Stack;

public class PostfixToPrefix {
    public static String postfixToPrefix(String exp){
        Stack<String> st = new Stack<>();
        for(int i = 0;i<exp.length();i++){
            char ch = exp.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                st.push(Character.toString(ch));
            }
            else{
                String temp = st.peek();
                st.pop();
                String temp2 = st.peek();
                st.pop();
                st.push(ch+temp2+temp);
            }
        }
        return st.peek();
    }
    public static void main(String[] args) {
        String exp = "AB-DE+F*/";
        System.out.println("Postfix expression: "+exp);
        System.out.println("Prefix expression: "+postfixToPrefix(exp));

    }
}
