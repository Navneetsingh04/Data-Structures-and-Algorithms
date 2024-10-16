import java.util.Stack;
public class ReverseString {
    public static void main(String args[]){
        Stack<Character> st = new Stack<>();
        String str = "Navneet Singh";
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            st.push(ch);
        }
        while(!st.isEmpty()){
            System.out.print(st.peek());
            st.pop();
        }
    }
}
