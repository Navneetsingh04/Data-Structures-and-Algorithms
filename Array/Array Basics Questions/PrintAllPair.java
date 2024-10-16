/*Find all pais in the Given array */
public class PrintAllPair {
    public static void main(String args[]){
        int arr[] = new int[]{1,2,3,4};
        System.out.println("Printing all the pairs of the Array");
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr.length;j++){
                System.out.print("("+arr[i]+","+arr[j]+")"+",");
            }
            System.out.println();
        }
    }
}