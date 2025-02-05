// Time Complexity : O(2^n)*n

import java.util.ArrayList;
public class PrintSubSequence {
    public static void printSubsequence(int index,int arr[],ArrayList<Integer> list,int n){
        if(index == n){
            for(int i : list){
                System.out.print(i+" ");
            }
            if(list.isEmpty()){
                System.out.print("{}");
            }
            System.out.println();
            return;
        }
        printSubsequence(index+1, arr, list, n);
        list.add(arr[index]);
        printSubsequence(index+1, arr, list, n);
        list.remove(list.size()-1);
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3};
        int n = arr.length;
        int index = 0;
        ArrayList<Integer> list = new ArrayList<>();
        printSubsequence(index,arr, list, n);
    }
}