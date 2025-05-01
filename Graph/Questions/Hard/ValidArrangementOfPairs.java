/*
L.C:2097. Valid Arrangement of Pairs

You are given a 0-indexed 2D integer array pairs where pairs[i] = [starti, endi]. An arrangement of pairs is valid if for every index i where 1 <= i < pairs.length, we have endi-1 == starti.

Return any valid arrangement of pairs.

Note: The inputs will be generated such that there exists a valid arrangement of pairs.

Example 1:
Input: pairs = [[5,1],[4,5],[11,9],[9,4]]
Output: [[11,9],[9,4],[4,5],[5,1]]
Explanation:
This is a valid arrangement since endi-1 always equals starti.
end0 = 9 == 9 = start1 
end1 = 4 == 4 = start2
end2 = 5 == 5 = start3

Example 2:
Input: pairs = [[1,3],[3,2],[2,1]]
Output: [[1,3],[3,2],[2,1]]
Explanation:
This is a valid arrangement since endi-1 always equals starti.
end0 = 3 == 3 = start1
end1 = 2 == 2 = start2
The arrangements [[2,1],[1,3],[3,2]] and [[3,2],[2,1],[1,3]] are also valid.

Example 3:
Input: pairs = [[1,2],[1,3],[2,1]]
Output: [[1,2],[2,1],[1,3]]
Explanation:
This is a valid arrangement since endi-1 always equals starti.
end0 = 2 == 2 = start1
end1 = 1 == 1 = start2
 
Constraints:
1 <= pairs.length <= 105
pairs[i].length == 2
0 <= starti, endi <= 109
starti != endi
No two pairs are exactly the same.
There exists a valid arrangement of pairs. 
*/

// Time Complexity: O(N)
// Space Complexity: O(N)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ValidArrangementOfPairs {
    public static int[][] validArrangement(int[][] pairs) {

        Map<Integer,List<Integer>> adj = new HashMap<>();
        Map<Integer,Integer> indegree = new HashMap<>();
        Map<Integer,Integer> outdegree = new HashMap<>();
        for(int it[] : pairs){
            int u = it[0];
            int v = it[1];

            adj.computeIfAbsent(u,k -> new ArrayList<>()).add(v);
            outdegree.put(u,outdegree.getOrDefault(u,0)+1);
            indegree.put(v,indegree.getOrDefault(v,0)+1);
        }
        int startNode = pairs[0][0];
        for(int node : adj.keySet()){
            if(outdegree.getOrDefault(node,0) - indegree.getOrDefault(node,0) == 1){
                startNode = node;
                break;
            }
        }
        List<Integer> eulerPath = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        st.push(startNode);

        while(!st.isEmpty()){
            int curr = st.peek();
            if(adj.containsKey(curr) && !adj.get(curr).isEmpty()){
                int ngbr = adj.get(curr).remove(adj.get(curr).size()-1);
                st.push(ngbr);
            } 
            else{
                eulerPath.add(curr);
                st.pop();
            }
        }
        Collections.reverse(eulerPath);
        int[][] ans = new int[eulerPath.size()-1][2];
        for(int i= 0;i<eulerPath.size()-1;i++){
            ans[i][0] = eulerPath.get(i);
            ans[i][1] = eulerPath.get(i+1);
        }
        return ans;
    }
  
    //Approach-2 (DFS Using Recursion) - Hierholzer's Algorithm to find Euler Path
    //T.C : O(V+E)
    //S.C : O(V+E)

    public static Map<Integer, List<Integer>> adj = new HashMap<>();
    public static List<Integer> eulerPath = new ArrayList<>();

    public static void dfs(int node) {
        while (adj.containsKey(node) && !adj.get(node).isEmpty()) {
            int nextNode = adj.get(node).remove(adj.get(node).size() - 1);  // Remove the edge after visiting
            dfs(nextNode); 
        }
        eulerPath.add(node); 
    }

    public static int[][] validArrangementI(int[][] pairs) {
        // Step-1: Build adjacency list and calculate in-degree & out-degree
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, Integer> outdegree = new HashMap<>();

        for(int[] edge : pairs){
            int u = edge[0];
            int v = edge[1];

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            outdegree.put(u, outdegree.getOrDefault(u, 0) + 1);
            indegree.put(v, indegree.getOrDefault(v, 0) + 1);
        }

        // Step-2: Find the start node of the Eulerian path
        int startNode = pairs[0][0];
        for (int node : adj.keySet()) {
            if (outdegree.getOrDefault(node, 0) - indegree.getOrDefault(node, 0) == 1) {
                startNode = node;  // Node with outdegree > indegree by 1
                break;
            }
        }

        // Step-3: Perform DFS from the start node to find the Eulerian path
        dfs(startNode);

        // Step-4: Build the result from the Eulerian path
        Collections.reverse(eulerPath);
        int[][] result = new int[eulerPath.size() - 1][2];
        for(int i = 0; i < eulerPath.size() - 1; i++){
            result[i][0] = eulerPath.get(i);
            result[i][1] = eulerPath.get(i + 1);
        }

        return result;
    }


    public static void main(String[] args) {
        int [][] pairs = {{5,1},{4,5},{11,9},{9,4}};
        System.out.println("Valid Arrangement of Pairs: ");
        int[][] result = validArrangementI(pairs);
        for (int[] pair : result) {
            System.out.println(Arrays.toString(pair));
        }
    }
}
