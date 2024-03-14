// Find the sum of the array

import java.util.Scanner;
public class SumOfArray {
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
        int sum = 0;
        // for(int i = 0;i<arr.length;i++){
        //     sum += arr[i];
        // }
        for(int i :arr){
            sum += i;
        }
        System.out.println("The sum of array is "+sum);
        s.close();
    }
}

