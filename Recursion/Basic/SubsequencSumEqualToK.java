
import java.util.ArrayList;

public class SubsequencSumEqualToK {
    public static void printSum(int index,ArrayList<Integer> list,int k,int sum,int arr[],int n){
        if(index == n){
            if(k == sum){
                for(int i : list){
                    System.out.print(i+" ");
                }
                System.out.println();
            }
            return;
        }
        list.add(arr[index]);
        sum += arr[index];
        printSum(index+1, list, k,sum, arr, n);
        sum -= arr[index];
        list.remove(list.size()-1);
        printSum(index+1, list, k, sum,arr, n);
    }
    public static void main(String[] args) {
        int arr[] = {1,2,1,3};
        int n = arr.length;
        int k = 3;
        int index = 0;
        int sum = 0;
        ArrayList<Integer> list = new ArrayList<>();
        printSum(index,list,k,sum,arr,n);
    }
}
