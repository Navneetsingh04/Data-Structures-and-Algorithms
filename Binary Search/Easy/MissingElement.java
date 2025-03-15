public class MissingElement {
    public static int missingElement(int arr[]){
        int n = arr.length;
        int s = 0;
        int end = n-1;
        int ans = -1;
        while(s<=end){
            int mid = s+(end-s)/2;
            int difference = arr[mid]-mid;
            if(difference == 1){
                s = mid+1;
            }
            else{
                ans = mid;
                end = mid-1;
            }
        }
        if(ans+1 == 0 ){
            return n+1;
        }
        return ans+1;
    }
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,5,6,7,8};
        int result = missingElement(arr);
        System.out.println("Missing element is "+ result);
    }
}
