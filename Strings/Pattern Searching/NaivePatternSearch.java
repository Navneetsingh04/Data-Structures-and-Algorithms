// Time Complexity: O(n*m)
public class NaivePatternSearch {
    public static void patternSearch(String text,String pattern){
        int n = text.length();
        int m = pattern.length();
        char txt[] = text.toCharArray();
        char pat[] = pattern.toCharArray();
        for(int i = 0;i<n-m;i++){
            int j;
            for(j = 0;j<m;j++){
                if(txt[i+j] != pat[j]) break;
            }
            if(j == m){
                System.out.println("Pattern is found at position "+i);
            }
        }
    }
    public static void main(String[] args) {
        String text = "AABAACAADAABAAABAA";
        String pattern = "AABA";
        patternSearch(text, pattern);
    }
}
