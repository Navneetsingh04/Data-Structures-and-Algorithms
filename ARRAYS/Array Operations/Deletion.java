import java.util.Scanner;
public class Deletion {
    public static void deleteElement(int arr[],int n,int position){
        if(position < 1 || position > n){
            System.out.println("Inavlid Position");
        }
        else{
            for(int i = position;i<n-1;i++){
                arr[i] = arr[i+1];
            }
            n--;
        }
    }
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n = s.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the Element in the array");
        for(int i = 0;i<n;i++){
            arr[i] = s.nextInt();
        }
        System.out.print("Array Befor Deleted: ");
        for(int i: arr){
            System.out.print(i+" ");
        }
        System.out.print("\nEnter the positon to delete an element: ");
        int position = s.nextInt();
        deleteElement(arr, n, position);
        System.out.print("Array after deletion: ");
        for(int i = 0;i<n-1;i++){
            System.out.print(arr[i]+" ");
        }
        s.close();
    }
}