// package Searching And Sorting;
import java.util.Scanner;
public class LinearSearch_01 {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int arr[] = new int[]{7,4,8,9,3,5,2,56};
        System.out.print("Enter the target element: ");
        int target = s.nextInt();

        // 1st method

        boolean flag = false;
        // for(int i: arr){
        //     if(i == target){
        //         flag = true;
        //         break;
        //     }
        // }
        // if(flag==true){
        //     System.out.println("target found");
        // }
        // else{
        //     System.out.println("target Not found");
        // }

        // 2nd Method

        for(int i =0;i<arr.length;i++){
            if(arr[i]==target){
                System.out.println("Element found at "+i+" index");
                flag = true;
                break;
            }
        }
        if(!flag){
            System.out.println("Element not found");
        }
        s.close();
    }
}
