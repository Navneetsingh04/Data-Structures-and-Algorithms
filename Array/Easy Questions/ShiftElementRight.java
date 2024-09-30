/*
WAP to shift all elements of the array one position to the right
 */
public class ShiftElementRight {
    public static void main(String args[]){
        int arr[] = new int[]{4,54,5,45,8,7};
        System.out.print("Printing before Shifing: ");
        for(int i :arr){
            System.out.print(i+" ");
        }
        int lastelement = arr[arr.length-1];
        for(int i = arr.length-1;i>0;i--){
            arr[i] = arr[i-1];
        }
        arr[0] = lastelement;
        System.out.print("\nPrinting after Right Shifing: ");
        for(int i :arr){
            System.out.print(i+" ");
        }
        
    }
}
