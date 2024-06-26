/*
Merge Sort: Counting Inversions

In an array, , the elements at indices  and  (where ) form an inversion if . In other words, inverted elements  and  are considered to be "out of order". To correct an inversion, we can swap adjacent elements.

Example
To sort the array, we must perform the following two swaps to correct the inversions:
The sort has two inversions:  and .
Given an array , return the number of inversions to sort the array.
Sample Input

STDIN       Function
-----       --------
2           d = 2
5           arr[] size n = 5 for the first dataset
1 1 1 2 2   arr = [1, 1, 1, 2, 2]
5           arr[] size n = 5 for the second dataset     
2 1 3 1 2   arr = [2, 1, 3, 1, 2]
Sample Output

0  
4   
Explanation

We sort the following  datasets:

 is already sorted, so there are no inversions for us to correct.
We performed a total of  swaps to correct inversions.
 */
public class CountingInversion {
    // public static int countInversion(int arr[]){
    //     int count = 0;
    //     for(int i = 0;i<arr.length;i++){
    //         for(int j = i+1;j<arr.length;j++){
    //             if(arr[i]>arr[j]){
    //                 count++;
    //             }
    //         }
    //     }
    //     return count;
    // }
    public static int merg(int arr[],int temp[],int start,int end,int mid){
        int i = start;
        int j = mid+1;
        int k = start;
        int count = 0;
        while(i<=mid && j<=end){
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }
            else{
                // inversion count
                temp[k++] = arr[j++];
                count += (mid-i+1);
            }
        }
        while(i<=mid){
            temp[k++] = arr[i++];
        }
        while(j<= end){
            temp[k++] = arr[j++];
        }
        while(start <= end){
            arr[start] = temp[start];
            start++;
        }
        return count;
    }
    public static int mergSort(int arr[],int temp[],int start,int end){
        int count = 0;
        if(start<end){
            int mid = start+(end-start)/2;
            count += mergSort(arr, temp, start, mid);
            count += mergSort(arr, temp, mid+1, end);
            count += merg(arr,temp,start,end,mid);
        }
        return count;
    }
    public static int countInversion(int arr[]){
        int temp[] = new int[arr.length];
        return mergSort(arr,temp,0,arr.length-1);
    }
    public static void main(String[] args) {
        int arr[] = new int[]{2,4,1};
        System.out.println(countInversion(arr));
    }
}
