import java.util.Stack;
public class RemoveRedundantBrackets {
    static Stack<Character> st = new Stack<>();
    public static boolean checkRedundant(String str){
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch == '(' || ch == '+' || 
            ch == '-' || ch == '*' ||
            ch == '/'){
                st.push(ch);
            }
            else if(ch == ')'){
                int opCount = 0;
                while(!st.isEmpty() && st.peek() != '('){
                    char temp = st.peek();
                    if(temp == '+' || temp == '-' || temp == '*' || temp == '/'){
                        opCount++;
                    }
                    st.pop();
                }
                st.pop();
                if(opCount == 0){
                    return true;
                }
            }
        }
       return false;
    }
    public static void main(String args[]){
        String str = "(((a+b)*(a*b)))";
        boolean ans = checkRedundant(str);
        if(ans){
            System.out.println(str+" have Redundant Brackets");
        }
        else{
            System.out.println(str+" have no Redundant Brackets");
        }
    }
}
