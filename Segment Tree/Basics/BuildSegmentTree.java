public class BuildSegmentTree{
    static int n;
    static int segmentTree[];
    static int arr[];
    private static void buildTree(int i,int l,int r){
        if(l == r){
            segmentTree[i] = arr[l]; 
            return;
        }
        int mid = (l+r)/2;
        buildTree(2*i+1, l, mid);
        buildTree(2*i+2, mid+1, r);

        segmentTree[i] = segmentTree[2*i+1]+segmentTree[2*i+2];
    }
    private static void buildSegmentTree(int arr[]){
        n = arr.length;
        segmentTree = new int[4*n];
        buildTree(0,0,n-1);
    }
    public static void main(String[] args) {
        arr = new int[]{3,1,2,7};
        buildSegmentTree(arr);
        for(int i = 0;i<2*n;i++){
            System.out.print(segmentTree[i]+" ");
        }
    }
}