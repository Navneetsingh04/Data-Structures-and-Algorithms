public class MerSort{
    public static void merg(int arr[],int start,int end,int mid){
        int leftLen =  mid-start+1;
        int rightLen = end-mid;
        // creating left and right array
        int left[] = new int[leftLen];
        int right[] = new int[rightLen];
        // copy values from  original array t0 left array
        int k = start;
        for(int i = 0;i<leftLen;i++){
            left[i] = arr[k];
            k++;
        }
        // copy values from  original array to Right array
        k = mid+1;
        for(int i = 0;i<rightLen;i++){
            right[i] = arr[k];
            k++;
        }
        // marging
        int leftIndex = 0;
        int rightIndex = 0;
        int mainArrayIndex = start;

        while(leftIndex < leftLen && rightIndex < rightLen){
            if(left[leftIndex] < right[rightIndex]){
                arr[mainArrayIndex] = left[leftIndex];
                mainArrayIndex++;
                leftIndex++;
            }
            else{
                arr[mainArrayIndex] = right[rightIndex];
                mainArrayIndex++;
                rightIndex++;
            }
        } 
        // 1 case -> left array exhaust but right array have some element left
        while(rightIndex < rightLen){
            arr[mainArrayIndex] = right[rightIndex];
            mainArrayIndex++;
            rightIndex++;
        }

        // 2 case -> Right array exhaust but left array have some element left
        while(leftIndex < leftLen){
            arr[mainArrayIndex] = left[leftIndex];
            mainArrayIndex++;
            leftIndex++;
        }
    }
    public static void mergSort(int arr[],int start,int end){
        if(start >= end){
            return;
        }
        int mid = start+(end-start)/2;
        // recursive call for left array
        mergSort(arr, start, mid);
        // recursive call for right array
        mergSort(arr, mid+1, end);
        merg(arr,start,end,mid);

    }
    public static void main(String[] args) {
        int arr[] = new int[]{2,1,6,9,4,5};
        int start = 0;
        int end = arr.length-1;
        System.out.print("Before merg Sort: ");
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        mergSort(arr, start, end);
        System.out.println();
        System.out.print("After merg Sort: ");
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
