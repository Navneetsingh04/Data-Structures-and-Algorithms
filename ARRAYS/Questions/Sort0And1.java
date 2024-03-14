/*
Sort 0's and 1's first print all the 0's then print all the 1's
 */
public class Sort0And1 {
    public static void main(String rags[]){
        int arr[] = new int[]{1,1,0,1,0,1,0,1,0,1,0,1,0,1,0};
        System.out.println("printing array before Sorting 0's and 1's");
        for(int i:arr){
            System.out.print(i+" ");
        }
        // 1st method: using Count0 and 1

        // int count0 = 0;
        // for(int i = 0;i<arr.length;i++){
        //     if(arr[i]==0){
        //         count0++;
        //     }
        // }
        // int newArray[] = new int[arr.length];
        // for(int i = 0;i<count0;i++){
        //     newArray[i] = 0;
        // }
        // for(int i = count0;i<arr.length;i++){
        //     newArray[i] = 1;
        // }
        // System.out.println("\nprinting after Sorting 0's and 1's");
        // for(int i:newArray){
        //     System.out.print(i+" ");
        // }

        // Method 2: Using two Pointer

        int l = 0;
        int r = arr.length-1;
        while(l<r){
            while(arr[l] == 0 && l<r){
                l++;
            }
            while(arr[r]==1 && l<r){
                r--;
            }
            if(l<r){
                int temp = arr[l];
                arr[l] =arr[r];
                arr[r] =temp;
                l++;
                r--;
            }
        }
        System.out.println("\nprinting after Sorting 0's and 1's");
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}
