public class Minmium {
    public static int minmium(int arr[],int index,int mini){
        if(index >= arr.length){
            return mini;
        }
        mini = Math.min(mini, arr[index]);
        return minmium(arr, index+1, mini);
    }
    public static void main(String[] args) {
        int arr[] = new int[]{5,8,6,74,18,9,4,18};
        int mini = Integer.MAX_VALUE;
        System.out.println(minmium(arr, 0, mini));
    }
}
