public class ReverseArray {
    public static void main(String args[]){
        int arr[] = new int[]{45,545,11,52,5,89,63,25,42,15,32};
        System.out.println("Array Before reverse: ");
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
        int l = 0;
        int h = arr.length-1;
        while(l<=h){
            int temp = arr[l];
            arr[l] = arr[h];
            arr[h] = temp;
            l++;
            h--;
        }
        System.out.println("Array after reverse: ");
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}
