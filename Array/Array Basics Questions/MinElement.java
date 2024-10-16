// package Array Questions;

public class MinElement {
    public static void main(String args[]){
        int arr[] = new int[]{45,545,11,52,5,89,63,25,42,15,32};
        int min = arr[0];
        for(int i = 0;i<arr.length;i++){
            // if(arr[i]<min){
            //     min = arr[i];
            // }

            // 2nd method
            min = Math.min(min,arr[i]);
        }
        System.out.println("Minimun elemnt in the Array is: "+min);
    }
}
