/*
WAP  to find the missing element froam a Array with Duplicates
 */
// Time complexity : O(n);
// space Complexity :O(1)

// public class MissingElement {
//     public static void missingElement(int arr[]){
//         // Visited
//         for(int i = 0;i<arr.length;i++){
//             int index = Math.abs(arr[i]);
//             if(arr[index-1]>0){
//                 arr[index-1] *= -1;
//             }
//         }
//         for(int i = 0;i<arr.length;i++){
//             if(arr[i]>0){
//                 System.out.println(i+1);
//             }
//         }
//     }

// 2nd Approach : swap and sort
// Time complexity : O(n)
// space complexity: O(1)

public class MissingElement {
    public static void missingElement(int arr[]){
        for(int i = 0;i<arr.length;i++){
            int index = arr[i]-1;
            if(arr[i]!= arr[index]){
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index]  = temp;
            }
            else{
                i++;
            }
        }
        for(int i = 0;i<arr.length;i++){
            if(arr[i]!=i+1){
            System.out.print(i+1+" ");
            }
        }
    }
public static void main(String[] args) {
    // int arr[ ] = new int[]{1,3,5,3,4};
    // int arr[] = new int[]{1,3,3,2,4};
    int arr[] = new int[]{1,3,3,3,4};
    missingElement(arr);

    }
}
