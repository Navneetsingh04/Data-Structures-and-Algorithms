public class FindTheLongestSubstring {
    public static int findTheLongestSubstring(String s) {
        int prefixXOR = 0;
        int[] chMap = new int[26];
        chMap['a' -'a'] = 1;
        chMap['e' -'a'] = 2;
        chMap['i' -'a'] = 4;
        chMap['o' -'a'] = 8;
        chMap['u' -'a'] = 16;
        int mp[] = new int[32];
        for(int i =0;i<32;i++){
            mp[i] = -1;
        }
        int longest = 0;
        for(int i = 0;i<s.length();i++){
            prefixXOR ^= chMap[s.charAt(i)-'a'];
            if(mp[prefixXOR] == -1 && prefixXOR != 0){
                mp[prefixXOR] = i;
            }
            longest = Math.max(longest,i-mp[prefixXOR]);
        }
        return longest;
    }
    public static void main(String[] args) {
        String s = "eleetminicoworoep";
        System.out.println(findTheLongestSubstring(s)); 
    }
}
