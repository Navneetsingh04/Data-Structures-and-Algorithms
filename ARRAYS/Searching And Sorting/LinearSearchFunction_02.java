// using linear serach find the elemnent and if elemnt is found then reurn elemnt is found.
import java.util.Scanner;
public class LinearSearchFunction_02 {
    boolean linearSearch(int arr[],int target){
        for(int element :arr){
            if(element==target){
                return true;
            }
        }
        return false;
    }
    public static void main(String args[]){
    Scanner s = new Scanner(System.in);
        int arr[] = new int[]{7,4,8,9,3,5,2,56};
        System.out.print("Enter the target element: ");
        int target = s.nextInt();
        LinearSearchFunction_02 Ls = new LinearSearchFunction_02();
        boolean isfound = Ls.linearSearch(arr, target);
        if(isfound){
            System.out.println("Element is found");
        }
        else
        System.out.println("Element is not found");
        s.close();
    }
}
