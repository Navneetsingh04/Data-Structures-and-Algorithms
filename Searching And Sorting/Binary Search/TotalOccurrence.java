public class TotalOccurrence {
    public static int lastOccurrence(int arr[],int target){
        int n = arr.length;
        int s = 0,end = n-1;
        int ans = -1;
        while(s<=end){
            int mid = s+(end-s)/2;
            if(arr[mid]==target){
                // store ans
                ans = mid;
                // move to right because we have to find last occurence
                s = mid+1;
            }
            else if(arr[mid]<target){
                s = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return ans;
    }
    public static int firstOccurence(int arr[],int target){
        int n = arr.length;
        int s = 0,end = n-1;
        int ans = -1;
        while(s<=end){
            int mid = s+(end-s)/2;
            if(arr[mid]==target){
                // store ans
                ans = mid;
                // move to left
                end = mid-1;
            }
            else if(arr[mid]<target){
                s = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return ans;
    }
    public static int totalOccurence(int arr[],int target){
        int first = firstOccurence(arr,target);
        int last = lastOccurrence(arr, target);
        int Total = last-first+1;
        return Total;
    }
    public static void main(String[] args) {
        int arr[] = new int[]{10,20,30,30,30,30,40,40,40,50,60};
        int target = 30;
        int result = totalOccurence(arr, target);
        System.out.println("Total occurence of the "+target+" is "+result);
        
    }
}

