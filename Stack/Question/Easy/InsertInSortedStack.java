import java.util.Stack;
public class InsertInSortedStack{
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
    public static void main(String args[]){
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);

        int element = 24;
        insertSorted(st, element);
        while(!st.isEmpty()){
            System.out.print(st.peek()+" ");
            st.pop();
        }
    }
}
