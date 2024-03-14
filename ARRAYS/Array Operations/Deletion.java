import java.util.Scanner;
public class Deletion {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n = s.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the Element array");
        for(int i = 0;i<n;i++){
            arr[i] = s.nextInt();
        }
        System.out.print("Array Befor Deleted: ");
        for(int i: arr){
            System.out.print(i+" ");
        }
        System.out.print("\nEnter the positon from which you want to delete an element: ");
        int position = s.nextInt();

        if(position<0 || position>=n){
            System.out.println("Invalid position!");
        }
        else{
            for(int i  = position;i<n-1;i++){
                arr[i] = arr[i+1];
            }
            n--;
            System.out.println("Element deleted Sucessfully!");
        }
        System.out.print("\nArray after deletion: ");
        for(int i = 0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        s.close();
    }

}