public class PairSum {
    public static void main(String args[]){
        int arr[] = new int[]{1,2,3};
        int sum = 0;
        // for(int i = 0;i<arr.length;i++){
        //     for(int j = 0;j<arr.length;j++){
        //         sum = arr[i]+arr[j];
        //         System.out.println("Sum of pairs ("+arr[i]+","+arr[j]+") is "+sum);
        //     }
        // }

        // distinct sum

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                sum = arr[i] + arr[j];
                System.out.println("Sum of pair (" + arr[i] + ", " + arr[j] + ") = " + sum);
            }
        }
    }
}
