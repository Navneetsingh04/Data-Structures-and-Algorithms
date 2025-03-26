public class MerSort{
    public static void merg(int arr[],int l,int mid,int r){
        int n1 = mid-l+1;
        int n2 = r-mid;
        int leftArr[] = new int[n1];
        int rightArr[] = new int[n2];
        
        for(int i = 0;i<n1;i++){
            leftArr[i] = arr[l+i];
        }
        for(int i= 0;i<n2;i++){
            rightArr[i] = arr[mid+1+i];
        }
        int i = 0,j = 0,k = l;
        while(i<n1 && j<n2){
            if(leftArr[i] <= rightArr[j]){
                arr[k++] = leftArr[i++];
            }
            else{
                arr[k++] = rightArr[j++];
            }
        }
        while(i<n1){
            arr[k++] = leftArr[i++];
        }
        while(j<n2){
            arr[k++] = rightArr[j++];
        }
    }
    public static void mergSort(int arr[],int l,int r){
        if(l<r){
            int mid = l+(r-l)/2;
            mergSort(arr,l,mid);
            mergSort(arr,mid+1,r);
            merg(arr,l,mid,r);
        }
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
