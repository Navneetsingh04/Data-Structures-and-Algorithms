// Printing the Even index of java

import java.util.Scanner;
public class EvenIndex {
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
        System.out.println("Printing the Even Index Value of array");
        for(int i = 1;i<=arr.length;i += 2){
            System.out.print(arr[i]+" ");
        }
        s.close();
    }
}