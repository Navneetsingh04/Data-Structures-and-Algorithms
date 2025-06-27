import java.util.ArrayList;
import java.util.List;
public class RevreseSpiralPrint {
    public static List<Integer> spiralPrint(int matrix[][]){
        List<Integer> ans = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        int total = row*col;

        int startingrow = 0;
        int endingcol = col-1;
        int endingrow = row-1;
        int startingcol = 0;
        int count = 0;
        while(count<total){
            // print Strting col
            for(int i = startingrow;i<=endingrow && count<total;i++){
                ans.add(matrix[i][startingcol]);
                count++;
            }
            startingcol++;
            // print ending row
            for(int i = startingcol;i<=endingcol && count<total;i++){
                ans.add(matrix[endingrow][i]);
                count++;
            }
            endingrow--;
            // print ending col
            for(int i = endingrow;i>=startingrow && count<total;i--){
                ans.add(matrix[i][endingcol]);
                count++;
            }
            endingcol--;
            // printing  starting row
            for(int i = endingcol;i>=startingcol && count<total;i--){
                ans.add(matrix[startingrow][i]);
                count++;
            }
            startingrow++;
        }
        return ans;

    }
    public static void main(String[] args) {
        int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> result = spiralPrint(matrix);
        System.out.print(result+" ");

    }
}

