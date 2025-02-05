import java.util.Stack;
public class ReverseStack {
    public static void insertAtBottom(Stack<Integer> st,int element){
        if(st.isEmpty()){
            st.push(element);
            return;
        }
        int temp = st.peek();
        st.pop();

        insertAtBottom(st, element);
        st.push(temp);
    }
    public static void reverseStack(Stack<Integer> st){
        if(st.isEmpty()){
            return;
        }
        int temp = st.peek();
        st.pop();
        reverseStack(st);
        insertAtBottom(st,temp);
    }
    public static void main(String args[]){
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);

        reverseStack(st);
        while(!st.isEmpty()){
            System.out.print(st.peek()+" ");
            st.pop();
        }
    }
}
