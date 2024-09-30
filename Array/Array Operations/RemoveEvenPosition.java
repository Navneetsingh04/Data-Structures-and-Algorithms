import java.util.Scanner;
public class RemoveEvenPosition{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the no of element in the array: ");
        int n = s.nextInt();
        int arr[] = new int[n]; 
        for(int i = 0;i<n;i++){
            arr[i] = s.nextInt();
        }
        System.out.println("Printing the no of element in the array: ");
        // removes element from Even Positions
        for(int i = 1;i<arr.length;i += 2){   
             // removes element from Odd positions
            // for(int i = 0;i<arr.length;i += 2){
            System.out.print(arr[i]+" ");
        }
        s.close();
        
    }
    
}