
import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {
    public static int[] nextSmaller(int nums[]){
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int ans[] = new int[n];
        for(int i = 0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()] > nums[i]){
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
        int nums[] = {15,4,2,25,18,42,45,7};
        int ans[] = nextSmaller(nums);
        System.out.print("Next Smallest element: ");
        System.out.print(Arrays.toString(ans));
    }
}