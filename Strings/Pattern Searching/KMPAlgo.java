public class KMPAlgo {
    public static void kmp(String s, String pattern) {
        int n = s.length();
        int m = pattern.length();
        int lps[] = new int[m];
        int j = 0;
        LSPArray(pattern, m, lps);
        int i = 0;

        while (i < n) {
            if (pattern.charAt(j) == s.charAt(i)) {
                i++;
                j++;
            }
            if (j == m) {
                System.out.println("found pattern at " + (i - j));
                j = lps[j - 1];
            } 
            else if (i < n && pattern.charAt(j) != s.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } 
                else {
                    i++;
                }
            }
        }
    }
    public static void LSPArray(String pattern, int m, int lps[]) {
        int len = 0;
        lps[0] = 0;
        int i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } 
            else {
                if (len != 0) {
                    len = lps[len - 1];
                } 
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
    public static void main(String[] args) {
        String s = "abcabcdab";
        String pattern = "abcdab";
        kmp(s, pattern);
    }
}
