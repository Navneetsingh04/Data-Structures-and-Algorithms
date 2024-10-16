// WAP to count and return the number of even elements in an array
public class CountEvenNumber {
    public static int countEvenNumber(int arr[]){
        int count = 0;
        for(int i = 0;i<arr.length;i++){
            if((arr[i]&1)==0){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int arr[] = new int[]{4,58,89,8,88,46,48,85,45,81,5,18,7};
        int result = countEvenNumber(arr);
        System.out.println("Total number of even elements in an array is "+result);
    }
}
