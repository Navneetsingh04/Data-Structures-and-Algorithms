import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class KeyboardRow {
    // public String[] findWords(String[] words) {
    //     Set<String> set = new HashSet<>(Arrays.asList("qwertyuiop","asdfghjkl","zxcvbnm"));
    //     for(String str: words){
    //         set.add(str);
    //     }

    // }
    public static void main(String[] args) {
        Set<String> set = new HashSet<>(Arrays.asList("qwertyuiop","asdfghjkl","zxcvbnm"));
        for( String i : set){
            System.out.println(i);
        }
    }
}
