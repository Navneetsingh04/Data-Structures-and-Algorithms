public class TwoDtoOneD{
    public static int[] twoDtoOneD(int arr[][]){
        int row = arr.length;
        int col = arr[0].length;
        int n = row*col;
        int[] oneDArray = new int[n];
        // int k = 0;
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                // oneDArray[k++] = arr[i][j];
                oneDArray[col*i+j] = arr[i][j];
            }
        }
        return oneDArray;
    }
    public static void main(String args[]){
        int arr[][] = new int[][]{{1,2,3,4},{5,6,7,8},{9,1,0,1,12},{13,14,15,16}};
        int[] oneDArray = twoDtoOneD(arr);
        for(int num:oneDArray){
            System.out.print(num+" ");
        }
    }
}
