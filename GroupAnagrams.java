//Time Complexity: O(n * k) because we are iterating over the source string and the primeProduct creation traverses over the length of the string (k)
//Space Complexity: O(n * k) because we are storing all the strings along with their prime product as the keys
//Did this code successfully run on Leetcode : Yes
//Approach: We will maintain a map of Double and list of strings, the key will be the hash of the string (prime product of the string) and the list will contain all the anagrams
//if we get the hash in the map, we will simply add the string to the list in the map, else add a new key value pair, and add the string in the list
//This approach will work because the hash key of two strings ate, eat will be the same
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Groups anagrams
 */
public class GroupAnagrams {

    /**
     *
     * @param strs the strings that need to be grouped
     * @return     a list of anagram strings
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        final Map<Double, List<String>> mappings = new HashMap<>();
        for (String str : strs) {
            double primeProduct = primeProduct(str);

            if (!mappings.containsKey(primeProduct)) {
                mappings.put(primeProduct, new ArrayList<>());
            }
            mappings.get(primeProduct).add(str);
        }

        return new ArrayList<>(mappings.values());
    }

    /**
     * Double data type because we may overshoot the range of integers
     *
     * @param str the string to generate the prime product for
     * @return calculate and return the prime product of the string
     */
    private double primeProduct(final String str) {
        int[] prime = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};

        double result = 1.0;
        for (char ch : str.toCharArray()) {
            result = result * (prime[ch - 'a']);
        }

        return result;
    }

    public static void main(String[] args) {
        final GroupAnagrams groupAnagrams = new GroupAnagrams();
        System.out.println(groupAnagrams.groupAnagrams(new String[] {"tea", "ate", "tan", "ant", "pant", "tie", "meat", "team", "tame"}));
        //returns [["tea", "ate"], ["tan, "ant"], ["pant"], ["tie"], ["meat", "team", "tame"]]
        System.out.println(groupAnagrams.groupAnagrams(new String[] {"paps"})); //[["paps"]]
    }
}
