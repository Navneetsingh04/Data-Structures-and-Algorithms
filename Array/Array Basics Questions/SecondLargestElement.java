/*
Given an array of positive integers arr[], return the second largest element from the array. If the second largest element doesn't exist then return -1. 
*/
public class SecondLargestElement {
    public static int secondLargest(int arr[]){
        int n = arr.length;
        if(arr == null || n < 2){
            return -1;
        }
        int max = arr[0];
        int secondMax = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]>max){
                secondMax = max;
                max = arr[i];
            }
            else if (arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }
        if(secondMax == Integer.MIN_VALUE){
            return -1;
        }
        return secondMax;
    }
    public static void main(String rags[]){
        int arr[] =  new int[]{45,18,7,4,17,25};
        int result = secondLargest(arr);
        System.out.println("The second largest element in an array is "+result);
    }
    
}
