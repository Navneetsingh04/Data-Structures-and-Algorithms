import java.util.Stack;

public class PrefixToInfix {
    public static String prefixToInfix(String exp){
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
                String combined = "("+temp+ch+temp2+")";
                st.push(combined);
            }
        }
        return st.peek();
    }
    public static void main(String[] args) {
        String exp = "*+PQ-MN";
        System.out.println("Prefis operation: "+exp);
        System.out.println("Infix Expression: "+prefixToInfix(exp));
    }
}
