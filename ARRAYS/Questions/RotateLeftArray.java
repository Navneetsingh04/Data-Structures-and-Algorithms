import java.util.Scanner;
public class RotateLeftArray{
    public static void reverse(int arr[],int left,int right){
        while(left<right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    public static void shiftKelemnt(int arr[],int k){
        int n = arr.length;
        k = k%n;
        reverse(arr,0,k);
        reverse(arr,k+1, n-1);
        reverse(arr,0,n-1);
        for(int i: arr){
            System.out.print(i+" ");
        }
    }
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the size of the Array: ");
        int size = s.nextInt();
        System.out.println("Enter the element in the array: ");
        int arr[] = new int[size];
        for(int i = 0;i<arr.length;i++){
            arr[i] = s.nextInt();
        }
        System.out.print("Printing array before Shifting: ");
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.print("\nEnter the number of element you want to shift: ");
        int k = s.nextInt();
        System.out.print("Printing array after Shifting "+k+" positions: ");
        shiftKelemnt(arr,k);
        s.close();
    }
}