public class ArrayTarvarsal {
    public static void arrayTarvarsal(int arr[],int index){
        if(index == arr.length){
            return;
        }
        System.out.print(arr[index]+" ");
        arrayTarvarsal(arr,index+1);
    }
    public static void main(String args[]){
        int arr[] = new int[]{1,2,3,4,5,8,9,6};
        System.out.print("Array: ");
        arrayTarvarsal(arr, 0);
    }
}