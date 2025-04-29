/*
L.C: 1319. Number of Operations to Make Network Connected

There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where connections[i] = [ai, bi] represents a connection between computers ai and bi. Any computer can reach any other computer directly or indirectly through the network.

You are given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected.

Return the minimum number of times you need to do this in order to make all the computers connected. If it is not possible, return -1.


Example 1:
Input: n = 4, connections = [[0,1],[0,2],[1,2]]
Output: 1
Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.

Example 2:
Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
Output: 2

Example 3:
Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
Output: -1
Explanation: There are not enough cables.
 
Constraints:
1 <= n <= 105
1 <= connections.length <= min(n * (n - 1) / 2, 105)
connections[i].length == 2
0 <= ai, bi < n
ai != bi
There are no repeated connections.
No two computers are connected by more than one cable. 
*/
public class NumOfOperationsToMakeNetworkConnected {
    public static int makeConnected(int n, int[][] connections) {
        int cntExtra = 0;
        int parent[] = new int[n];
        int size[] = new int[n];

        for(int i= 0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
        for(int con[] : connections){
            int u = con[0];
            int v = con[1];
            if(find(u,parent) ==  find(v,parent)){
                cntExtra++;
            }
            else{
                unionBySize(u,v,parent,size);
            }
        }

        int cntComp = 0;
        for(int i= 0;i<n;i++){
            if(parent[i] == i) cntComp++;
        }
        int ans = cntComp-1;
        if(cntExtra >= ans){
            return ans;
        }
        return -1;
    }
    public static int find(int u,int parent[]){
        if(parent[u] != u){
            parent[u] = find(parent[u],parent);
        }
        return parent[u];
    }
    public static void unionBySize(int  u,int v,int parent[],int size[]){
        int pu = find(u,parent);
        int pv = find(v,parent);

        if(pu == pv)  return;

        if(size[pu] < size[pv]){
            parent[pu] = pv;
            size[pv] += size[pu];
        }
        else{
            parent[pv] = pu;
            size[pu] += size[pv];
        } 
    }
    public static void main(String[] args) {
        int n = 4;
        int[][] connections = {
            {0, 1},
            {0, 2},
            {1, 2}
        };
        System.out.println(makeConnected(n, connections)); 
    }
}
