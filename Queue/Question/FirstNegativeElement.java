import java.util.ArrayDeque;
import java.util.Deque;
public class FirstNegativeElement {
    public static void printFirstNegative(int arr[],int k){
        Deque<Integer> dq = new ArrayDeque<>();

        // processing first k element
        for(int index = 0;index<k;index++){
            if(arr[index] < 0){
                dq.add(index);
            }
        }

        // process remaning window -> removal and Addition
        for(int index = k;index<arr.length;index++){
            // before going farward find the answer of old window
            if(dq.isEmpty()){
                System.out.println("0");
            }
            else{
                System.out.print(arr[dq.peek()]+" ");
            }
            // Removal
            if(index - dq.peek() >= k){
                dq.pollFirst();
            }
            // Addition
            if(arr[index] < 0){
                dq.add(index);
            }
        }
        if(dq.isEmpty()){
            System.out.println("0");
        }
        else{
            System.out.print(arr[dq.peek()]+" ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {2,-5,4,-1,-2,0,5};
        printFirstNegative(arr, 3);
    }
}