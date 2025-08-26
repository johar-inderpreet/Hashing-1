//Time Complexity: O(n) because we are iterating over the source string
//Space Complexity: O(N) because the target map will store String keys, the source map will have a max of 26 keys, O(26), overall O(N)
//Did this code successfully run on Leetcode : Yes
//Approach: We will maintain two maps one for source to target mappings and one for target to source mappings.
//If the split on s string based on white space does not result in an array with the same length as pattern, return false
//the rest of the problem is similar to the Isomorphic Strings problem where we were mapping source to the target and target to the source
//with the condition that, if the source already has a target mapping different from the current value we are trying to map it to, return false
//similarly, if the target already has a source mapping different from the current value we are trying to map it to, return false
import java.util.HashMap;
import java.util.Map;

/**
 * Checks if the pattern matches the string
 */
public class WordPattern {

    /**
     *
     * @param pattern the pattern
     * @param s       the string
     * @return  true if the pattern matches the string, false otherwise
     */
    public boolean wordPattern(String pattern, String s) {
        final String[] split = s.split(" ");
        if (split.length != pattern.length()) return false;

        final Map<Character, String> source = new HashMap<>();
        final Map<String, Character> target = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            final Character sourceStr = pattern.charAt(i);
            final String targetStr = split[i];

            if (source.containsKey(sourceStr)) {
                if (!source.get(sourceStr).equals(targetStr)) return false;
            } else {
                source.put(sourceStr, targetStr);
            }

            if (target.containsKey(targetStr)) {
                if (!target.get(targetStr).equals(sourceStr)) return false;
            } else {
                target.put(targetStr, sourceStr);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        final WordPattern wordPattern = new WordPattern();
        System.out.println(wordPattern.wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern.wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(wordPattern.wordPattern("abba", "dog cat cat fish"));
    }
}
