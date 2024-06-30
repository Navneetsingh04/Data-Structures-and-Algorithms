public class RatInMaze {
    public static boolean isSafe(int newx,int newy,int maze[][],int row,int col,boolean visited[][]){
        // possibility may be
            // path closed
            // out of bound
            // check is postion is already visited
            return (newx >= 0 && newx < row && newy >= 0 && newy <col && maze[newx][newy] == 1 && visited[newx][newy] == false);       
    }
    public static void printAllPath(int maze[][],int row,int col,int srcx,int srcy,String output,boolean visited[][]){
        if(srcx == row-1 && srcy == col-1){
            System.out.println(output+" ");
            return;
        }
        // UP
        int newx = srcx-1;
        int newy = srcy;
        if(isSafe(newx, newy, maze, row, col, visited)){
            // Mark visited
            visited[newx][newy] = true;
            // Recurssion
            printAllPath(maze, row, col, newx, newy, output+'U', visited);
            // Backtracking
           visited[newx][newy] = false;
        }
        // Right
        newx = srcx;
        newy = srcy+1;
        if(isSafe(newx, newy, maze, row, col, visited)){
            // Mark visited
            visited[newx][newy] = true;
            // Recurssion
            printAllPath(maze, row, col, newx, newy, output+'R', visited);
            // Backtracking
            visited[newx][newy] = false;
        }
        // Down

        newx = srcx+1;
        newy = srcy;
        if(isSafe(newx, newy, maze, row, col, visited)){
            // Mark visited
            visited[newx][newy] = true;
            // Recurssion
            printAllPath(maze, row, col, newx, newy, output+'D', visited);
            // Backtracking
            visited[newx][newy] = false;
        }

        // Left
        newx = srcx;
        newy = srcy-1;
        if(isSafe(newx, newy, maze, row, col, visited)){
            // Mark visited
            visited[newx][newy] = true;
            // Recurssion
            printAllPath(maze, row, col, newx, newy, output+'L', visited);
            // Backtracking
            visited[newx][newy] = false;
        }
    }
    public static void main(String[] args) {
        int maze[][] = new int[][]{
        {1,0,0,0},
        {1,1,0,0},
        {1,1,1,0},
        {1,1,1,1}};
        int row = maze.length;
        int col = maze[0].length;
        int srcx = 0;
        int srcy = 0;
        String output = "";
        boolean[][] visited = new boolean[row][col];
        if(maze[0][0] == 0){
            System.out.println("No path exists");
        }
        else{
            visited[srcx][srcy] = true;
            System.out.println("paths that rat can visited to reach the distantion are : ");
            printAllPath(maze,row,col,srcx,srcy,output,visited);
        }
    }
}