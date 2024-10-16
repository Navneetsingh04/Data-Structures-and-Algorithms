public class MaxNumber {
    public static int maximum(int arr[],int index,int maxi){
        if(index >= arr.length){
            return maxi;
        }
        maxi = Math.max(arr[index],maxi);
        return maximum(arr, index+1, maxi);
    }
    public static void main(String[] args) {
        int arr[] = new int[]{1,8,4,9,45,12,85,47,96,48};
        int maxi = Integer.MIN_VALUE;
        System.out.println("Maximum element in the array is: "+maximum(arr, 0, maxi));
    }
}
