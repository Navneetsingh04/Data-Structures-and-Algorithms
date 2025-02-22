/*
L.C: 1079. Letter Tile Possibilities

You have n  tiles, where each tile has one letter tiles[i] printed on it.

Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.

Example 1:
Input: tiles = "AAB"
Output: 8
Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".

Example 2:
Input: tiles = "AAABBC"
Output: 188

Example 3:
Input: tiles = "V"
Output: 1

Constraints:
1 <= tiles.length <= 7
tiles consists of uppercase English letters. 
*/

// import java.util.HashSet;
// import java.util.Set;

public class LetterTilePossiblities {
    // T.C: O(n.n!)
    // S.C: O(n.n!)
    // public static int numTilePossiblities(String tiles){
    //     int n = tiles.length();
    //     Set<String> set = new HashSet<>();
    //     boolean used[] = new boolean[n];

    //     findSequences(tiles,"",used,set,n);
    //     return set.size()-1;
    // }
    // public static void findSequences(String tiles,String curr,boolean used[],Set<String> set,int n){
    //     set.add(curr);

    //     for(int i = 0;i<n;i++){
    //         if(!used[i]){
    //             used[i] = true;
    //             findSequences(tiles, curr+tiles.charAt(i), used, set, n);
    //             used[i] = false;
    //         }
    //     }
    // }

    // 2nd Approach

    // T.C: O(k^k)
    // S.C: O(n)
    public static int numTilePossiblities(String tiles){
        int count[] = new int[26];
        for(char ch : tiles.toCharArray()){
            count[ch-'A']++;
        }
        return findSequences(count);
    }
    public static int findSequences(int count[]){
        int totalCount = 0;
        for(int i = 0;i<26;i++){
            if(count[i] == 0){
                continue;
            }
            totalCount++;
            count[i]--;
            totalCount += findSequences(count);
            count[i]++;
        }
        return totalCount;
    }
    public static void main(String[] args) {
        String tiles = "AAABBC";
        System.out.println(numTilePossiblities(tiles));
    }
}
