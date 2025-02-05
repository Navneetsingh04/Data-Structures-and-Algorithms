import java.util.Stack;
public class MiddleElement {
    public static int solve(Stack<Integer> st,int pos){
        if(pos == 1){
            return st.peek();
        }
        pos--;
        int temp = st.peek();
        st.pop();
        // ṛecursion
        int ans = solve(st, pos);
        // backtrack
        st.push(temp);
        return ans;
    }
    public static int getMid(Stack<Integer> st){
        int size = st.size();
        if(st.isEmpty()){
            return -1;
        }
        else{
            int pos = 0;
            if((size&1)==1){
                pos = size/2+1;
            }
            else{
                pos = size/2;
            }
            int ans = solve(st,pos);
            return ans;
        }
    }

    public static void main(String args[]){
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(50);
        st.push(60);
        st.push(70);
        st.push(80);

        int mid = getMid(st);
        System.out.println("Middle Element is : "+mid);
    }
}
