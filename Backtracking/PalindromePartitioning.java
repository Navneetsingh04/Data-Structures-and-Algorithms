/*
L.C: 131. Palindrome Partitioning

Given a string s, partition s such that every 
substring of the partition is a palindrome.
Return all possible palindrome partitioning of s.

Example 1:
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]

Example 2:
Input: s = "a"
Output: [["a"]]

Constraints:
1 <= s.length <= 16
s contains only lowercase English letters. 
*/
import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
        public List<List<String>> partition(String s) {
        List<String> list = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        func(0,s,ans,list);
        return ans;
    }
    public void func(int index,String s,List<List<String>> ans,List<String> list){
        if(index == s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                list.add(s.substring(index,i+1));
                func(i+1,s,ans,list);
                list.remove(list.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s,int start,int end){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "aabb";
        PalindromePartitioning obj = new PalindromePartitioning();
        List<List<String>> ans = obj.partition(s);
       System.out.println(ans);
    }
}
