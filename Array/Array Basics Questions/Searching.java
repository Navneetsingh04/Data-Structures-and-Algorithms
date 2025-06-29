// using linear serach find the elemnent and return its index.
import java.util.Scanner;

import Easy.Searching;
public class Searching{
    int linearSearch(int arr[],int target){
        for(int i = 0;i<arr.length;i++){
            if(arr[i]==target){
                return i;
            }
        }
        return -1;
    }
    public static void main(String args[]){
    Scanner s = new Scanner(System.in);
        int arr[] = new int[]{7,4,8,9,3,5,2,56};
        System.out.print("Enter the target element: ");
        int target = s.nextInt();
        Searching Ls = new Searching();
        int index = Ls.linearSearch(arr, target);
        if(index != -1){
            System.out.println("Element is found at "+index+" index");
        }
        else
        System.out.println("Element is not found");
        s.close();
    }
}
