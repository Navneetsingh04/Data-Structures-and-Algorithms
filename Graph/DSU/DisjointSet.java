import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    DisjointSet(int n){
        for(int i = 0;i<=n;i++){
            parent.add(i);
            // rank.add(0);
            size.add(1);
        }
    }
    public int findParent(int node){
        if(node == parent.get(node)){
            return node;
        }
        int ulp = findParent(parent.get(node));
        parent.set(node,ulp); 
        return ulp;
    }

    public void unionByRank(int u,int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if(ulp_u == ulp_v) return;

        if(rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
        }
        else if(rank.get(ulp_v) < rank.get(ulp_u)){
            parent.set(ulp_v,ulp_u);
        }
        else{
            parent.set(ulp_v,ulp_u);
            rank.set(ulp_u,rank.get(ulp_u)+1);
        }
    }
    public void unionBySize(int u,int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);

        if(ulp_u == ulp_v) return;

        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_v) + size.get(ulp_u));
        }
        else{
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u) + size.get(ulp_v));
        }
    }
    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);
        ds.unionBySize(1, 2);
        ds.unionBySize(2,3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6,7);
        ds.unionBySize(5,6);

        // if 3 and 7 same componenet or not
        if(ds.findParent(3) == ds.findParent(7)){
            System.out.println("Same component");
        }
        else{
            System.out.println("Different component");
        }
        ds.unionBySize(3, 7);
        if(ds.findParent(3) == ds.findParent(7)){
            System.out.println("Same component");
        }
        else{
            System.out.println("Different component");
        } 
    }
}
