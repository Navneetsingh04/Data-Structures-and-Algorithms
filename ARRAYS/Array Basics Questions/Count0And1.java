// package Array Questions;

public class Count0And1 {
    public static void main(String args[]){
        int arr[] = new int[]{1,0,1,0,1,0,1,0,1,0,1,0,1};
        int count0 = 0;
        int count1 = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == 0){
                count0 += 1;
            }
            else{
                count1 += 1;
            }
        }
        System.out.println("There are "+count0+" Zero's and "+count1+" one's in the array");
    }
}
