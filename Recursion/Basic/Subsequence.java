// Time complexity : O(2^n)
// space Complexity: O(n)

import java.util.ArrayList;
import java.util.List;

public class Subsequence {
    public static void printSubsequence(int index, List<Integer> list,int arr[]){
        int n = arr.length;
        if(index == n){
            for(int i : list){
                System.out.print(i+" ");
            }
            if(list.isEmpty()){
                System.out.println("{}");
            }
            System.out.println("");
            return;
        }
        list.add(arr[index]);
        printSubsequence(index+1, list, arr);
        list.remove(list.size()-1);
        printSubsequence(index+1, list, arr);
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3};
        List<Integer> list = new ArrayList<>();
        printSubsequence(0,list,arr);
    }
}
