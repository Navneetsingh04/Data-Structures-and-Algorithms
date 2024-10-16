/*
find pivot index
 */
public class FindPivotElement {
    public static int findPivotElement(int arr[]){
        int n = arr.length;
        int s = 0;
        int end = n-1;
        while(s<=end){
            int mid = s+(end-s)/2;
            if(s==end){
                return s;
            }
            if(arr[mid]<arr[mid-1]){
                return mid-1;
            }
            else if(arr[mid]>arr[mid+1]){
                return mid;
            }
            else if(arr[s]>arr[mid]){
                end = mid-1;
            }
            else{
                s = mid+1;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        int arr[] = new int[]{12,14,16,2,4,6,8,10};
        int result = findPivotElement(arr);
        System.out.println("Pivot index is "+result);
    }
}
