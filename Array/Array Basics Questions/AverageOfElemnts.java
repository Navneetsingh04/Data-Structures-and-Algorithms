// WAP to calculate and return the average of all elements in an array
public class AverageOfElemnts {
    public static int averageOfElemnts(int arr[]){
        int sum = 0;
        for(int i = 0;i<arr.length;i++){
            sum += arr[i];
        }
        return (sum/arr.length);
    }
    public static void main(String[] args) {
        int arr[] =  new int[]{4,8,46,28,23,2,51,18,4};
        int result = averageOfElemnts(arr);
        System.out.println("The average of elements in an array is "+result);
    }
}