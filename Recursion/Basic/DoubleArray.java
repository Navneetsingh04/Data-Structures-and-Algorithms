public class DoubleArray {
    public static void doubleArray(int arr[],int index){
        if(index >= arr.length){
            return;
        }
        System.out.print(2*arr[index]+" ");
        doubleArray(arr, index+1);
    }
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,56};
        doubleArray(arr, 0);
    }
}
