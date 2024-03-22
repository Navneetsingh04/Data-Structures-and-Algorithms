// Time complexity : O(n^3)

// public class FindAllSubarray {
//     public static void findAllSubarray(int arr[]){
//         int n = arr.length;
//         int count = 0;
//         for(int i = 0;i<n;i++){
//             for(int j = i;j<n;j++){
//                 for(int k = i;k<=j;k++){
//                     System.out.print(arr[k]+" ");
//                 }
//                 System.out.println();
//                 count++;
//             }
//         }
//         System.out.println("Total number of subarray is: "+count);
//     }


// 2nd Approach two pointer
// Time complexity : O(n^2)
public class FindAllSubarray {
    public static void findAllSubarray(int arr[]){
        int n = arr.length;
        int start = 0;
        int end = 0;
        while (start < n) {
            while (end < n) {
                for (int i = start; i <= end; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
                end++;
            }
            start++;
            end = start;
        }
    }
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3};
        findAllSubarray(arr);
    }
}