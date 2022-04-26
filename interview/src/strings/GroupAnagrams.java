/**
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * Example :
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * */
package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
        
        private List<List<String>> groupAnagrams(String[] strs) {
                // base case
                if (strs == null || strs.length == 0) {
                        return new ArrayList<>();
                }
                Map<String, List<String>> map = new HashMap<>();
                for (String s : strs) {
                        // character array
                        char[] ca = new char[26];
                        for (char ch : s.toCharArray()) {
                                ca[ch - 'a']++;
                        }
                        // converting character array as a string for comparison
                        String keyStr = String.valueOf(ca);
                        // adding string as key for 1st time and allocating memory to store its anagrams
                        if (!map.containsKey(keyStr)) {
                                map.put(keyStr, new ArrayList<>());
                        }
                        // adding the anagram
                        map.get(keyStr).add(s);
                }
                return new ArrayList<>(map.values());
        }
        
        public static void main(String[] args) {
                String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
                System.out.println("Grouped Anagrams : " + new GroupAnagrams().groupAnagrams(strs));
        }
}
