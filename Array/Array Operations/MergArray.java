import java.util.Scanner;
public class MergArray {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the size of first array: ");
        int n = s.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the Element in 1st array");
        for(int i = 0;i<arr.length;i++){
            arr[i] = s.nextInt();
        }
        System.out.print("Enter the size of 2nd array: ");
        int n1 = s.nextInt();
        int arr1[] = new int[n1];
        System.out.println("Enter the Element in 2nd array");
        for(int i = 0;i<arr1.length;i++){
            arr1[i] = s.nextInt();
        }
        int newarr[] = new int[arr.length+arr1.length];
        int index = 0;
        for(int i = 0;i<arr.length;i++){
            newarr[index++] = arr[i];
        }
        for(int i = 0;i<arr1.length;i++){
            newarr[index++] = arr1[i];
        }
        System.out.println("Array after Merging: ");
        for(int i : newarr){
            System.out.print(i+" ");
        }
        s.close();
    }
}
