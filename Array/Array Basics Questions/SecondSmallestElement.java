// WAP to find and return the second smallest element in an array of integers
public class SecondSmallestElement {
    public static int secondSmallestElement(int arr[]){
        int min = arr[0];
        int secondMin = Integer.MAX_VALUE;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]<min){
                secondMin = min;
                min = arr[i];
            }
            else if(arr[i]<secondMin && arr[i] != min){
                secondMin = arr[i];
            }
        }
        return secondMin;
    }
    public static void main(String[] args) {
        int arr[] = new int[]{3,8,95,64,54,4,45,454,8} ;
        int result = secondSmallestElement(arr);
        System.out.println("The second smallest element in an array is "+result);
    }
}
