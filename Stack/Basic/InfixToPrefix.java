import java.util.Stack;
public class InfixToPrefix {
    public static int priority(char ch){
        if(ch == '^') return 3;
        else if(ch == '*' || ch == '/') return 2;
        else if(ch == '+' || ch == '-') return 1;
        else return -1;
    }
    public static String infixToPrefix(String exp){
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder("");
        StringBuilder str = new StringBuilder(exp);
        str.reverse();
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch == '('){
                str.setCharAt(i, ')');;
            }
            else if(ch == ')'){
                str.setCharAt(i, '(');
            }
        }
        
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                ans.append(ch);
            }
            else if(ch == '('){
                st.push(ch);
            }
            else if(ch == ')'){
                while(!st.isEmpty() && st.peek() != '('){
                    ans.append(st.peek());
                    st.pop();
                }
                st.pop();
            }
            else{
                while(!st.isEmpty() && priority(ch) <= priority(st.peek())){
                    ans.append(st.peek());
                    st.pop();
                }
                st.push(ch);
                }
            }
        while(!st.isEmpty()){
            ans.append(st.peek());
            st.pop();
        }
        ans.reverse();
        return ans.toString();
    }
    public static void main(String[] args) {
        String exp = "(A+B)*C-D+F";
        System.out.println("Infix Expression: " + exp);
        System.out.println("Prefix Expression: " + infixToPrefix(exp));
    }
}
