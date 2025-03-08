/*
GFG: Merge two binary Max heaps

Given two binary max heaps as arrays, merge the given heaps to form a new max heap.

Example 1:

Input  : 
n = 4 m = 3
a[] = {10, 5, 6, 2}, 
b[] = {12, 7, 9}
Output : 
{12, 10, 9, 2, 5, 7, 6}
*/
// Time Complexity: O(NlogN)
//space Complexity: O(n+m)
public class MergTwoBinaryMaxHeaps {
    public static void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void heapify(int arr[],int n,int index){
        int largestIndex = index;
        int leftIndex = 2*index+1;
        int rightIndex = 2*index+2;
        
        if(leftIndex < n && arr[leftIndex] > arr[largestIndex]){
            largestIndex = leftIndex;
        }
        if(rightIndex < n && arr[rightIndex] > arr[largestIndex]){
            largestIndex = rightIndex;
        }
        if(index != largestIndex){
            swap(arr,index,largestIndex);
            heapify(arr,n,largestIndex);
        }
    }
    public static int[] mergeHeaps(int[] a, int[] b, int n, int m) {
        // merging the arr
        int merged[] = new int[n+m];
        for(int i = 0;i<n;i++){
            merged[i] = a[i]; 
        }
        for(int i = 0;i<m;i++){
            merged[n+i] = b[i];
        }
        int size = n+m;
        for(int i = size/2-1;i>=0;i--){
            heapify(merged,size,i);
        }
        return merged;
    }
    public static void main(String[] args) {
        int a[] = {10,5,6,2};
        int b[] = {12,7,9};
        int n = a.length;
        int m = b.length;

        int ans[] = mergeHeaps(a, b, n, m);
        for(int i = 0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }
}