public class MaxElement{
    public static void main(String args[]){
        int arr[] = new int[]{45,545,11,52,5,89,63,25,42,15,32};
        int max = arr[0];
        for(int i = 0;i<arr.length;i++){
            // if(arr[i]>max){
            //     max = arr[i];
            // }

            // 2nd method
            max = Math.max(max,arr[i]);
        }
        System.out.println("Maximum elemnt in the Array is: "+max);
    }
}
