// Time Complexity : O(n^2)
public class PrintAllSubarray {
    public static void print(int arr[],int s,int end){
        if(end == arr.length){
            return;
        }
        for(int i = s;i<=end;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        print(arr, s, end+1);
    }

    public static void printAllSubarray(int arr[]){
        for(int s = 0;s<=arr.length;s++){
            int end = s;
            print(arr, s, end);
        }
    }
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,5}; 
        printAllSubarray(arr);
    }
}
