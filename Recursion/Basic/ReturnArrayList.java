import java.util.ArrayList;
public class ReturnArrayList {
    public static ArrayList<Integer> arrayList(int arr[],int target,int index,ArrayList<Integer> list){
        if(index == arr.length){
            return list;
        }
        if(arr[index] == target){
            list.add(index);
        }
        return arrayList(arr, target, index+1, list);
    }
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,4,8};
        int target = 4;
        ArrayList<Integer> list = new ArrayList<>();
        list = arrayList(arr, target, 0, list);
        System.out.println("Target element "+target+" is at Index "+list);
    }
}