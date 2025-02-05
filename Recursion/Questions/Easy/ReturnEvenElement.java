import java.util.ArrayList;
public class ReturnEvenElement {
    public static ArrayList<Integer> even(int arr[],ArrayList<Integer> list,int index){
        if(index >= arr.length){
            return list;
        }
        if((arr[index]&1) == 0){
            list.add(arr[index]);
        }
        return even(arr, list, index+1);
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int arr[] = new int[]{1,2,3,4,8,7,4,10};
        System.out.println(even(arr, list, 0));
    }
}
