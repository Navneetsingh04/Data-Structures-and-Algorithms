public class MergSortI {
    public static void merg(int nums[],int temp[],int start,int end,int mid){
        int i = start;
        int j = mid+1;
        int k = start;
        while(i <= mid && j <= end){
            if(nums[i] < nums[j]){
                temp[k++] = nums[i++];
            }
            else{
                temp[k++] = nums[j++];
            }
        }
        while(i <= mid){
            temp[k++] = nums[i++];
        }
        while(j <= end){
            temp[k++] = nums[j++];
        }
        while(start <= end){
            nums[start] = temp[start];
            start++;
        }
    }
    public static void mergSort(int nums[],int temp[],int start,int end){
        if(start >= end){
           return; 
        }
        int mid = start+(end-start)/2;
        mergSort(nums,temp,start,mid);
        mergSort(nums,temp,mid+1,end);
        merg(nums,temp,start,end,mid);
    }
    public static void main(String args[]){
        int arr[] = new int[]{4,8,1,29,9,2,45,18,7,25,42};
        int temp[] = new int[arr.length];
        int start = 0;
        int end = arr.length-1;
        mergSort(arr, temp, start, end);

        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}