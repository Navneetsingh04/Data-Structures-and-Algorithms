import java.util.ArrayList;
import java.util.Arrays;

public class RatInMaze2 {
    public void solve(int i,int j,int a[][],int n,ArrayList<String> ans,String move,
    int visit[][],int di[],int dj[]){
        if(i == n-1 && j == n-1){
            ans.add(move);
            return;
        }
        String dir = "DLRU";
        for(int index = 0;index<4;index++){
            int nexti = i+di[index];
            int nextj = j+dj[index];
            if(nexti >= 0 && nextj >= 0 && nexti < n && nextj < n && visit[nexti][nextj] == 0 && (a[nexti][nextj] == 1)){
                visit[i][j] = 1;
                solve(nexti,nextj,a,n,ans,move+dir.charAt(index),visit,di,dj);
                visit[i][j] = 0;
            }
        }
    }
    public ArrayList<String> findPath(int[][] mat) {
        int n = mat.length;
        ArrayList<String> ans = new ArrayList<>();
        int[][] visit = new int[n][n];
        for(int i[] : visit){
            Arrays.fill(i,0);
        }
        int di[] = {+1,0,0,-1};
        int dj[] = {0,-1,+1,0};
        if(mat[0][0] == 1){
            solve(0,0,mat,n,ans,"",visit,di,dj);
        }
        return ans;  
    }
    public static void main(String[] args) {
        int maze[][] = {
            {1,0,0,0},
            {1,1,0,0},
            {1,1,1,0},
            {1,1,1,1}};
        RatInMaze2 obj = new RatInMaze2();
        System.out.println(obj.findPath(maze));
    }
}
