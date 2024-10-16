import java.util.Scanner;
public class InsertAtPosition {
    public static int[] insertElement(int arr[],int n,int key,int position){
        if(position < 1 || position > n+1){
            System.out.println("Invalid Position");
            return arr;
        }
        int newArray[] = new int[n+1];
        for(int i = 0;i<position-1;i++){
            newArray[i] = arr[i];
        }
        newArray[position-1] = key;
        for(int i = position;i<newArray.length;i++){
            newArray[i] =  arr[i-1];
        }
        return newArray;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n = s.nextInt();
        int arr[] = new int[n];
        System.out.print("Enter the Element in array: ");
        for(int i = 0;i<n;i++){
            arr[i] = s.nextInt();
        }
        System.out.print("Array Befor insertion: ");
        for(int i: arr){
            System.out.print(i+" ");
        }
        System.out.print("\nEnter the position: ");
        int position = s.nextInt();
        System.out.print("Enter the element to insert: ");
        int key = s.nextInt();
        System.out.print("Array After insertion: ");
        arr = insertElement(arr, n, key, position);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        s.close();
    }
}
