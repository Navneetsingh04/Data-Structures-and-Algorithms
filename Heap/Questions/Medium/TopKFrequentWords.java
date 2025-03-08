/*
L.C: 692. Top K Frequent Words

Given an array of strings words and an integer k, return the k most frequent strings.
Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.

Example 1:
Input: words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.

Example 2:
Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
Output: ["the","is","sunny","day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
 
Constraints:
1 <= words.length <= 500
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
k is in the range [1, The number of unique words[i]]
  
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {
       static class MyComparator implements Comparator<Map.Entry<String,Integer>> {
        public int compare(Map.Entry<String,Integer> a,Map.Entry<String,Integer> b) {
            if(a.getValue().equals(b.getValue())){
                return b.getKey().compareTo(a.getKey());
            }
            return a.getValue() - b.getValue();
        }
    }
    public static List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for(String s : words){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        PriorityQueue<Map.Entry<String,Integer>> minHeap = new PriorityQueue<>(new MyComparator());
        // PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(
        //     (a, b) -> a.getValue().equals(b.getValue()) 
        //         ? b.getKey().compareTo(a.getKey())  // Sort lexicographically in reverse order
        //         : a.getValue() - b.getValue()       // Sort by frequency (ascending)
        // );
        for(Map.Entry<String,Integer> e : map.entrySet()){
            minHeap.offer(e);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        while(!minHeap.isEmpty()){
            ans.add(minHeap.poll().getKey());
        }
        Collections.reverse(ans);
        return ans;
    }
    public static void main(String[] args) {
        String[] words =
        {"i","love","leetcode","i","love","coding"};
        int k = 2;
        List<String> ans = topKFrequent(words, k);
        System.out.println(ans);
    }
}
