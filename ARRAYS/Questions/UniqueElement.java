/*
Find the Unique elemnt in the array where every element ocurs two times except one
 */
public class UniqueElement {
    public static int checkUnique(int arr[]){
        int ans = 0;
        for(int  i = 0;i<arr.length;i++){
          ans = ans^arr[i];
        }
        return ans;
}
    public static void main(String args[]){
        int arr[] = new int[]{10,10,2,2,25,8,6,8,6};
        int result = checkUnique(arr);
        System.out.println("Unique Element in the array is "+ result);
    }
}