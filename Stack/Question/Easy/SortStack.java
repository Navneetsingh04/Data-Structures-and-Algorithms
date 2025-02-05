import java.util.Stack;
public class SortStack {
    public static void insertSorted(Stack<Integer> st,int element){
        if(st.empty() || element>st.peek()){
            st.push(element);
            return;
        }
        int temp = st.peek();
        st.pop();

        insertSorted(st, element);
        st.push(temp);
    }
    public static void sortStack(Stack<Integer> st){
        if(st.isEmpty()){
            return;
        }
        int temp = st.peek();
        st.pop();

        sortStack(st);
        insertSorted(st, temp);
    }
    public static void main(String args[]){
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(40);
        st.push(11);
        st.push(27);
        st.push(5);

        sortStack(st);
        while(!st.isEmpty()){
            System.out.print(st.peek()+" ");
            st.pop();
        }
    }
}
