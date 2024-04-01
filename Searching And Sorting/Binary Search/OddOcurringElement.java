/*
find odd occurring element in which 
1. all element occur even no of time except one
2. one element occur more than two at a time
3. All pairs are repeat and not repeat
*/
// Time complexity: O(logn)

public class OddOcurringElement {
    public static int oddOcurringElement(int arr[]){
        int n = arr.length;
        int s = 0;
        int end = n-1;
        while(s<=end){
            if(s==end){
                return s;
            }
            int mid = s+(end-s)/2;
            // mid check even or odd
            if((mid&1)==1){
                if(mid-1 >= s && arr[mid] == arr[mid-1]){
                    s = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
            else{
                if(mid+1 <= end && arr[mid]==arr[mid+1]){
                    s = mid+2;
                }
                else{
                    // we are at right part or at answer
                    end = mid;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = new int[]{1,1,5,5,2,2,3,3,5,4,4};
        int ans =  oddOcurringElement(arr);
        System.out.println("Odd occuring element is "+arr[ans]);
    }
}
