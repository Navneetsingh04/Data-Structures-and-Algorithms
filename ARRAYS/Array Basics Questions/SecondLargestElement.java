// WAP to find and return the second largest element in an array of integers.
public class SecondLargestElement {
    public static int secondLargest(int arr[]){
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
        return secondMax;
    }
    public static void main(String rags[]){
        int arr[] =  new int[]{45,18,7,4,17,25};
        int result = secondLargest(arr);
        System.out.println("The second largest element in an array is "+result);
    }
    
}
