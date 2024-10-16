// Time Complexity: O(N)
// Space Complexity: O(N)
import java.util.Arrays;
import java.util.Stack;
public class MonotonicIncreasingStack {
    public static int[] monotonicStack(int nums[]){
        Stack<Integer> st = new Stack<>();
        for(int i: nums){
            while(!st.isEmpty() && st.peek() > i){
                st.pop();
            }
            st.push(i);
        }
        int ans[] = new int[st.size()];
        int index = st.size()-1;
        while(!st.isEmpty()){
            ans[index--] = st.pop();
        }
        return ans;
    }
    public static void main(String[] args) {
        int nums[] = {3,1,2,8,7,9,5,18};
        int ans[] = monotonicStack(nums);
        System.out.print("Monotonic incresing Stack: ");
        System.out.print(Arrays.toString(ans));
    }
}
