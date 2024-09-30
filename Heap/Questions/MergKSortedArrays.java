/*
GFG: Merge k Sorted Arrays

Given k sorted arrays arranged in the form of a matrix of size k * k. The task is to merge them into one sorted array. Return the merged sorted array 

Examples :
Input: k = 3, arr[][] = {{1,2,3},{4,5,6},{7,8,9}}
Output: 1 2 3 4 5 6 7 8 9
Explanation: Above test case has 3 sorted arrays of size 3, 3, 3 arr[][] = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]. The merged list will be [1, 2, 3, 4, 5, 6, 7, 8, 9].
Input: k = 4, arr[][]={{1,2,3,4},{2,2,3,4},{5,5,6,6},{7,8,9,9}}
Output: 1 2 2 2 3 3 4 4 5 5 6 6 7 8 9 9 
Explanation: Above test case has 4 sorted arrays of size 4, 4, 4, 4 arr[][] = [[1, 2, 2, 2], [3, 3, 4, 4], [5, 5, 6, 6], [7, 8, 9, 9 ]]. The merged list will be [1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 8, 9, 9].


Constraints:
1 <= k <= 100
*/

// Time Complexity: O(N*KlogN)

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

public class MergKSortedArrays {
    static class Info{
        int data;
        int arrayIndex;   // index of the array from which the element is taken
        int elementIndex;    // index of the element in the array
        Info(int data,int arrayIndex,int elementIndex){
            this.data = data;
            this.arrayIndex = arrayIndex;
            this.elementIndex = elementIndex;
        }
    }
    public static ArrayList<Integer> mergKSortedArrays(int arr[][],int k,int n){
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Info> minHeap = new PriorityQueue<>(new Comparator<Info>(){
            public int compare(Info a,Info b){
                return a.data - b.data;
            }
        });
        // Insert the first element of each array into the min-heap
        for(int i = 0;i<k;i++){
            if(arr[i].length > 0){
                minHeap.add(new Info(arr[i][0],i,0));
            }
        }
        // extracting the min element from the heap and insert the next element from the same array into the heap
        while(!minHeap.isEmpty()){
            Info current = minHeap.poll();
            ans.add(current.data);
            // Getting the next element from the same Array
            int nextElement = current.elementIndex+1;
            if(nextElement < arr[current.arrayIndex].length){
                minHeap.add(new Info(arr[current.arrayIndex][nextElement],current.arrayIndex,nextElement));
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[][] = {
            {1,4,8,11},
            {2,6,3,10},
            {5,7,12,14}
        };
        int k = 3;
        int n = 4;
        System.out.println("Given Arrays: ");
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        ArrayList<Integer> ans = mergKSortedArrays(arr,k,n);
        System.out.println("Sorted array: "+ans);
    }
}