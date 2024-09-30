import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestRangeCoveringElementsFromkLists {
    static class Info{
        int data;  
        int arrayIndex; // index of the array 
        int elementIndex; // index of the element in the array
        Info(int data,int arrayIndex,int elementIndex){
            this.data = data;
            this.arrayIndex = arrayIndex;
            this.elementIndex = elementIndex;
        }
    }
    public static int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Info> pq = new PriorityQueue<>(new Comparator<Info>(){
            public int compare(Info a,Info b){
                return a.data - b.data;
            }
        });
        int maxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;
        for(int i = 0;i<nums.size();i++){
            int element = nums.get(i).get(0);
            int row = i;
            int col = 0;
            Info temp = new Info(element,row,col);
            pq.add(temp);
            maxi = Math.max(maxi,element);
            mini = Math.min(mini,element);
        }
        int ansStart = mini;
        int ansEnd = maxi;

        while(!pq.isEmpty()){
            Info topNode = pq.peek();
            // int topData = topNode.data;
            int topCol = topNode.elementIndex;
            int topRow = topNode.arrayIndex;
            pq.poll();

            mini = topNode.data;

            if((maxi-mini)< (ansEnd-ansStart)){
                ansStart = mini;
                ansEnd = maxi;
            }
            // insertion
            if(topCol +1 <nums.get(topRow).size()){
                int newElement = nums.get(topRow).get(topCol+1);
                maxi = Math.max(maxi,newElement);
                Info newInfo = new Info(newElement,topRow,topCol+1);
                pq.add(newInfo);
            }
            // There no elment left;
            else{
                break;
            }
        }
        int ans[] = new int[2];
        ans[0] = ansStart;
        ans[1] = ansEnd;
        return ans;

    }
    public static void main(String[] args) {
        // int nums[][] = {{4,10,15,24,26},{0,9,12,20},{5,18,22,30}};
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(4, 10, 15, 24, 26));
        nums.add(Arrays.asList(0, 9, 12, 20));
        nums.add(Arrays.asList(5, 18, 22, 30));

        int ans[] = smallestRange(nums);
        System.out.println("Smallest Range: ["+ans[0]+","+ans[1]+"]");

    }
}
