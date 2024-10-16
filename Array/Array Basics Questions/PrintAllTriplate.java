// Time Complexity = O(n^3)
public class PrintAllTriplate {
    public static void main(String args[]){
        int arr[] = new int[]{1,2,3};
        System.out.println("Printing all the pairs of the Array");
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr.length;j++){
                for(int k = 0;k<arr.length;k++){
                System.out.print("("+arr[i]+","+arr[j]+","+arr[k]+")"+",");
                }
            }
        }
    }
}
