public class UpdateSegmentTree {
    static int n;
    static int arr[];
    static int segmentTree[];

    private static void buildTree(int i,int l,int r){
        if(l == r){
            segmentTree[i] = arr[l];
            return;
        }
        int mid = (l+r)/2;
        buildTree(2*i+1, l, mid);
        buildTree(2*i+2, mid+1, r);

        segmentTree[i] = segmentTree[2*i + 1]+segmentTree[2*i+2];
    }

    private static void buildSegmentTree(int arr[]){
        n = arr.length;
        segmentTree = new int[n*4];
        buildTree(0,0,n-1);
    }

    private static void updateSegmentTree(int idx,int val,int i,int l,int r){
        if(l == r){
            segmentTree[i] = val;
            return;
        }
        int mid = (l+r)/2;
        if(idx <= mid){
            updateSegmentTree(idx, val, 2*i+1, l, mid);
        }
        else{
            updateSegmentTree(idx, val, 2*i+2, mid+1, r);
        }
        segmentTree[i] = segmentTree[2*i+1]+segmentTree[2*i+2];
    }
    private static void printSegementTree(){
        for(int i = 0;i<2*n;i++){
            System.out.print(segmentTree[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        arr = new int[]{3,1,2,7};
        buildSegmentTree(arr);
        printSegementTree();
        int index = 1;
        int val = 2;
        updateSegmentTree(index, val, 0, 0, n-1);
        printSegementTree();
    }
}
