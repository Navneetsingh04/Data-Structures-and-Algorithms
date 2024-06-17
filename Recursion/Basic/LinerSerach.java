import java.util.ArrayList;
public class LinerSerach {
    static ArrayList<Integer> list = new ArrayList<>();
    public static int serach(int arr[],int index,int target){
        if(index >= arr.length){
            return -1;
        }
        if(arr[index] == target){
            list.add(index);
            // return index;
        }
        return serach(arr, index+1, target);
    }
    public static void main(String args[]){
        int arr[] = new int[]{1,8,9,45,12,48,4,18,25,7,4,4};
        int target = 4;
        int result = serach(arr, 0, target);
        if(result != -1){
            System.out.println(target+" is found at index "+result);
        }
        else{
            System.out.println("Element not found");
        }
        System.out.println(list);
    }
}
