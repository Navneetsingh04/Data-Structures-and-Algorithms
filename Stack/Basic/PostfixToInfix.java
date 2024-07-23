import java.util.Stack;
public class PostfixToInfix {
    public static String postfixToInfix(String exp){
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
                String combined = "("+temp2+ch+temp+")";
                st.push(combined);
            }
        }
        return st.peek();
    }
    public static void main(String args[]){
        String exp = "AB-DE+F*/";
        System.out.println("Postix Expression: "+exp);
        System.out.println("Infix expression: "+postfixToInfix(exp));
    }
}