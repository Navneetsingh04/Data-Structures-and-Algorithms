import java.util.Arrays;

public class BoxStacking {
    
    // Approach: 1. Recursive
    // T.C: O(n^2)
    // S.C: O(n^2)

    public static int maxHeightRec(int i,int boxes[][]){
        int ans = boxes[i][2];
        for(int j = i+1;j<boxes.length;j++){
            if(boxes[j][0] < boxes[i][0] && boxes[j][1] < boxes[i][1]){
                ans = Math.max(ans,boxes[i][2]+maxHeightRec(j,boxes));
            }
        }
        return ans;
    }
    public static int maxHeight(int height[],int width[],int length[]){
        int n = height.length;
        
        int boxes[][] = new int[n*6][3];
        int index = 0;

        for(int i= 0;i<n;i++){
            int h = height[i];
            int w = width[i];
            int l = length[i];

            boxes[index++] = new int[]{h,w,l};
            boxes[index++] = new int[]{w,h,l};
            boxes[index++] = new int[]{l,h,w};
            boxes[index++] = new int[]{h,l,w};
            boxes[index++] = new int[]{w,l,h};
            boxes[index++] = new int[]{l,w,h};

        }
        Arrays.sort(boxes,(a,b)->{
            if(a[0] == b[0]){
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(b[0], a[0]);
        });
        int ans = 0;

        for(int i = 0;i<n;i++){
            ans = Math.max(ans,maxHeightRec(i,boxes));
        }
        return ans;
    }

    // Approach: 2. DP(memorization)
    // T.C: O(n^2)
    // S.C: O(n^2)

    public static int maxHeightRec(int i, int boxes[][], int dp[]) {
        if (dp[i] != -1) {
            return dp[i];
        }
        
        int ans = boxes[i][2]; 
        
        for (int j = i + 1; j < boxes.length; j++) {
            if (boxes[j][0] < boxes[i][0] && boxes[j][1] < boxes[i][1]) {
                ans = Math.max(ans, boxes[i][2] + maxHeightRec(j, boxes, dp));
            }
        }
        
        return dp[i] = ans;
    }

    public static int maxHeightI(int[] height, int[] width, int[] length) {
        int n = height.length;
        int boxes[][] = new int[n * 3][3]; 
        
        int index = 0;
        for (int i = 0; i < n; i++) {
            int h = height[i], w = width[i], l = length[i];
            boxes[index++] = new int[]{Math.max(w, l), Math.min(w, l), h};  
            boxes[index++] = new int[]{Math.max(h, l), Math.min(h, l), w};  
            boxes[index++] = new int[]{Math.max(h, w), Math.min(h, w), l};  
        }
        Arrays.sort(boxes, (a, b) -> (b[0] * b[1]) - (a[0] * a[1]));

        int ans = 0;
        int dp[] = new int[boxes.length];
        Arrays.fill(dp, -1);
        for (int i = 0; i < boxes.length; i++) {
            ans = Math.max(ans, maxHeightRec(i, boxes, dp));
        }
        return ans;
    }

    public static void main(String[] args) {
        int height[] = {4,1,4,10};
        int width[] = {6,2,5,12};
        int length[] = {7,3,6,32};
        System.out.println(maxHeight(height,width,length));
        System.out.println(maxHeightI(height,width,length));
    }
}
