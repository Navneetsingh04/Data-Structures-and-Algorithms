import java.util.Scanner;
public class InsertAtPosition {
    public static void main(String[] args) {
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
        System.out.print("\nEnter the position you want to insert in the array: ");
        int position = s.nextInt();
        int newArray[] = new int[n+1];
        System.out.print("Enter the element to insert: ");
        int key = s.nextInt();
        for(int i = 0;i<position;i++){
            newArray[i] = arr[i];
        }
        newArray[position] = key;
        for(int i = position+1;i<newArray.length;i++){
            newArray[i] =  arr[i-1];
        }
        arr = newArray;
        System.out.print("Array After insertion: ");
            for(int i : arr) {
                System.out.print(i + " ");
            }
        s.close();
    }
}
