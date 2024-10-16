/*
WAP to shift all elements of the array one position to the right
 */
public class ShiftLeft {
    public static void main(String args[]){
        int arr[] = new int[]{4,54,5,45,8,7};
        System.out.print("Printing before Shifing: ");
        for(int i :arr){
            System.out.print(i+" ");
        }
        int temp = arr[0];
        for(int i = 0;i<arr.length-1;i++){
            arr[i] = arr[i+1];
        }
        arr[arr.length-1] = temp;
        System.out.print("\nPrinting After Left Shifing: ");
        for(int i :arr){
            System.out.print(i+" ");
        }
    }
}
