import java.util.Stack;

public class PreviousSmallerElement {
    public static int[] previousSmallerElement(int arr[]){
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int ans[] = new int[arr.length];
        for(int i = 0;i<arr.length;i++){
            int curr = arr[i];
            while(st.peek() >= curr){
                st.pop();
            }
            ans[i] = st.peek();
            st.push(curr);
        }
        return ans;
    }
    public static void main(String args[]){
        int arr[] = new int[]{8,4,6,2,3};
        int ans[] = new int[]{};
        ans = previousSmallerElement(arr);
        System.out.print("Previous smaller element of the array is: ");
        for(int i:ans){
            System.out.print(i+" ");
        }
    }
}
