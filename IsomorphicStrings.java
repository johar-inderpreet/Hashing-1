//Time Complexity: O(n) because we are iterating over the source string
//Space Complexity: O(1) because the maximum size of both the maps will be O(26)
//Did this code successfully run on Leetcode : Yes
//Approach: We will maintain two maps one for source to target mappings and one for target to source mappings, it is given that
//the two strings will be of the same length, so we won't add extra validation checks, if a map contains a character, and its value
//is not what we want to put in that particular iteration, return false (for both source and target mappings), else put the characters
//in both the maps
import java.util.HashMap;
import java.util.Map;

/**
 * Checks if two strings s and t are isomorphic
 */
public class IsomorphicStrings {

    /**
     *
     * @param s the source string
     * @param t the target string
     * @return returns true if the two strings are isomorphic, false otherwise
     */
    public boolean isIsomorphic(String s, String t) {

        final Map<Character, Character> sourceMappings = new HashMap<>();
        final Map<Character, Character> targetMappings = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (sourceMappings.containsKey(s.charAt(i))) {
                if (sourceMappings.get(s.charAt(i)).equals(t.charAt(i))) continue;
                else return false;
            } else {
                sourceMappings.put(s.charAt(i), t.charAt(i));
            }

            if (targetMappings.containsKey(t.charAt(i))) {
                if (!targetMappings.get(t.charAt(i)).equals(s.charAt(i))) return false;
            } else {
                targetMappings.put(t.charAt(i), s.charAt(i));
            }
        }

        return true;
    }

    public static void main(String[] args) {
        final IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
        System.out.println(isomorphicStrings.isIsomorphic("paper", "title"));
        System.out.println(isomorphicStrings.isIsomorphic("egg", "add"));
        System.out.println(isomorphicStrings.isIsomorphic("egg", "aid"));
        System.out.println(isomorphicStrings.isIsomorphic("e", "a"));
    }
}