import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternClass  {
    public static void main(String[] args) {
        String text = "abc123def456ghi";
        String pattern1 = "[abc]";    // a, b, or c
        String pattern2 = "[^abc]";   // Any character except a, b, or c
        String pattern3 = "[a-zA-Z]";    // a through z or A through Z, inclusive
        String pattern4 = "[a-d[m-p]]";     // a through d, or m through p: [a-dm-p] (union)
        String pattern5 = "[a-z&&[def]]";   // d, e, or f (intersection)
        String pattern6 = "[a-z&&[^bc]]";   // a through z, except for b or c: [ad-z] (subtraction)
        String pattern7 = "[a-z&&[^m-p]]";  // a through z, except for m through p

        findMatches(text, pattern1);
        findMatches(text, pattern2);
        findMatches(text, pattern3);
        findMatches(text, pattern4);
        findMatches(text, pattern5);
        findMatches(text, pattern6);
        findMatches(text, pattern7);
    }

    // Method to find and print matches for a given pattern
    public static void findMatches(String text, String pattern) {
        // Create a Pattern object
        Pattern p = Pattern.compile(pattern);

        // Create a Matcher object
        Matcher matcher = p.matcher(text);

        // Find and print matches
        System.out.print("Pattern \"" + pattern + "\": ");
        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }
        System.out.println();
    }
}

