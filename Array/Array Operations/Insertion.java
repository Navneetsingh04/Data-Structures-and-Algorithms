import java.util.Scanner;
public class Insertion {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n = s.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the Element array");
        for(int i = 0;i<n;i++){
            arr[i] = s.nextInt();
        }
        System.out.print("Array Befor insertion: ");
        for(int i: arr){
            System.out.print(i+" ");
        }
        System.out.print("\nEnter the number to insert in the array at front: ");
        int key = s.nextInt();

        // By creating new array

        int newArray[] = new int[n+1];
        for(int i = 0;i<n;i++){
            newArray[i+1] = arr[i]; // for insert at front
            // newArray[i] = arr[i];  // for insert at end
        }
        newArray[0] = key; // for insert at front
        // newArray[n] = key;   // for insert at end
        arr = newArray;
        System.out.print("Array After insertion at front: ");
        for(int i: arr){
            System.out.print(i+" ");
        }
        s.close();
    }
}