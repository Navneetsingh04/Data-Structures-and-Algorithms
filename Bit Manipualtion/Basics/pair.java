public class pair {
    public static int uniqueElement(int arr[]){
        int ans = 0;
        for(int i = 0;i<arr.length;i++){
            ans = arr[i]+ans;
        }
        return ans;
    }
    public static void main(String args[]){
        int arr[] = {-1,5,-8,-5,8,-1,4};
        System.out.println("Unique Element is "+uniqueElement(arr));
    }
}
