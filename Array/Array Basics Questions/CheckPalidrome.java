/*
You are given an array of integers. Write a function that determines whether the array is a palindrome or not. A palindrome is defined as a sequence of elements that reads the same forwards and backwards. The function should return true if the array is a palindrome and false otherwise.
Input: An array of integers.
Output:
true if the array is a palindrome.
false if the array is not a palindrome. 
*/
public class CheckPalidrome {
    public static boolean checkPalidrome(int arr[]){
        int l = 0;
        int r = arr.length-1;
        while(l<r){
            if(arr[l]!=arr[r]){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,1,8};
        // int arr[] = new int[]{1,2,1};
        boolean result = checkPalidrome(arr);
        if(result){
            System.out.println("The given Array is Palidrome");
        }
        else{
            System.out.println("The given Array is not a Palidrome");
        }
    }
}
