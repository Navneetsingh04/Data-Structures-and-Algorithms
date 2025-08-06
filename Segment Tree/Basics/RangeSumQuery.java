// Time Complexity: O(log n)

public class RangeSumQuery {
    static int segmentTree[];
    static int n;
    private static void buildSegmentTree(int i,int l,int r,int arr[],int segmentTree[]){
        if(l == r){
            segmentTree[i] = arr[l];
            return;
        }
        int mid = (l+r)/2;
        buildSegmentTree(2*i+1, l, mid, arr, segmentTree);
        buildSegmentTree(2*i+2,mid+1,r, arr, segmentTree);
        segmentTree[i] = segmentTree[2*i+1] + segmentTree[2*i+2];
    }
    private static int querySum(int start,int end,int index,int l,int r){
        // case 1: out of boound
        if(l > end || r < start) return 0;
        // case 2 : Entirely in the range
        if(l >= start && r <= end){
            return segmentTree[index];
        }
        // case 3: overlapping 
        int mid = (l+r)/2;
        return querySum(start, end, 2*index+1, l, mid)+ querySum(start, end, 2*index+2,mid+1,r);
    }
    public static void main(String[] args) {
        int arr[] = {3,1,2,7,2,1,2,3};
        n = arr.length;
        int start = 3, end = 6;
        segmentTree = new int[n*4];
        buildSegmentTree(0,0,n-1,arr,segmentTree);
        int ans = querySum(start,end,0,0,n-1);
        System.out.println("Range sum : "+ans);
    }
}
