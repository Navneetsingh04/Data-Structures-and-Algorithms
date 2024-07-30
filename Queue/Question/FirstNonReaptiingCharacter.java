import java.util.ArrayDeque;
import java.util.Queue;

public class FirstNonReaptiingCharacter {
    public static void main(String[] args) {
        String str = "ababc";
        Queue<Character> q = new ArrayDeque<>();
        int freq[] = new int[26];
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            freq[ch-'a']++;
            q.add(ch);

            while(!q.isEmpty()){
                char frontCharacter = q.peek();
                if(freq[frontCharacter-'a'] > 1){
                    q.poll();
                }
                else{
                    System.out.print(frontCharacter+" ");
                    break;
                }
            }
            if(q.isEmpty()){
                System.out.print("# ");
            }
        }
    }
}