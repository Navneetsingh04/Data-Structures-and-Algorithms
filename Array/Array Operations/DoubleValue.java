// Double the value of each elemnt in the array
import java.util.Scanner;
public class DoubleValue {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the Size of array: ");
        int n = s.nextInt();
        int arr[] = new int[n];

        System.out.println("Enter the element in the array");
        for(int i = 0;i<arr.length;i++){
            System.out.print("Enter "+(i+1)+" elemnt in array: ");
            arr[i] = s.nextInt();
        }
        System.out.println("Printing the array after the Doubling the elemnt of array");
        for(int i: arr){
            System.out.print(2*i+" ");
        }
        s.close();
    }
}
