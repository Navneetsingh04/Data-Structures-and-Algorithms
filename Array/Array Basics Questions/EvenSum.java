// WAP to calculate and return the sum of all even numbers in an array
public class EvenSum {
    public static int evenSum(int arr[]){
        int sum = 0;
        for(int i = 0;i<arr.length;i++){
            if((arr[i]&1)==0){
                sum += arr[i];
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int arr[] = new int[]{4,8,46,28,23,2,51,18,4};
        int result = evenSum(arr);
        System.out.println("The sum of all even numbers in an array is "+result);
    }
}
