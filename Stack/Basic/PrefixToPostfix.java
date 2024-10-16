import java.util.Stack;
public class PrefixToPostfix {
    public static String prefixToPostfix(String exp){
        Stack<String> st = new Stack<>();
        for(int i = exp.length()-1;i>=0;i--){
            char ch = exp.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                st.push(Character.toString(ch));
            }
            else{
                String temp = st.peek();
                st.pop();
                String temp2 = st.peek();
                st.pop();
                st.push(temp+temp2+ch);
            }
        }
        return st.peek();
    }
    public static void main(String[] args) {
        String exp = "/-AB*+DEF";
        System.out.println("prefix expression: "+exp);
        System.out.println("postfix Expression: "+prefixToPostfix(exp));
    }
}
