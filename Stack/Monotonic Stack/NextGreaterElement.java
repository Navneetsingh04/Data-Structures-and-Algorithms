import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static int[] nextGreater(int nums[]){
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[n];
        for(int i = 0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()] < nums[i]){
                int index = st.pop();
                ans[index] = nums[i];
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int index = st.pop();
            ans[index] = -1;
        }
        return ans;
    }
    public static void main(String[] args) {
        int nums[] = { 11,13,21,3};
        int ans[] = nextGreater(nums);
        System.out.print("Next Graeter Element: ");
        System.out.println(Arrays.toString(ans));
    }
}
