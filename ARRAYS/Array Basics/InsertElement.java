import java.util.Scanner;

public class InsertElement {
    public static void insertElement(int arr[], int n, int key, int position) {
        if(position < 1 || position > n) {
            System.out.println("Invalid Position");
            return;
        }
        for(int i = n-1;i >= position-1;i--) {
            arr[i+1] = arr[i];
        }
        arr[position - 1] = key;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the size of Array: ");
        int n = s.nextInt();
        int arr[] = new int[n+1]; 
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the "+(i+1)+" Element: ");
            arr[i] = s.nextInt();
        }
        System.out.print("Enter the postion: ");
        int position = s.nextInt();
        System.out.print("Enter the key to insert: ");
        int key = s.nextInt();
        System.out.print("Array Before Insertion: ");
        for(int i = 0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        insertElement(arr, n, key, position);
        System.out.print("Array After insertion: ");
        for (int i : arr) { 
            System.out.print(i + " ");
        }
        System.out.println();
        s.close();
    }
}
