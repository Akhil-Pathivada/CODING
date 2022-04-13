/**
 * Date 02/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Time Complexity : O(N ^ 3)
 * Space Complexity : O(1)
 *
 */
package slidingwindow;

import java.util.HashSet;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharactersI {
        
        private static boolean isDistinct(String s, int i, int j) {
                
                // Note : Default values in visited are false
                boolean[] visited = new boolean[26];
                HashSet<Character> set = new HashSet<>();
                for(int k = i; k <= j; k++) {
                        if (set.contains(s.charAt(k))) {
                                return false;
                        }
                        set.add(s.charAt(k));
                }
                return true;
        }
        
        private static int longestSubstring(String s) {
                
                HashSet<Character> set = new HashSet<>();
                int n = s.length(), maxLen = 0;
                for(int i =0; i < n; ++i) {
                        // get all possible substrings
                        for(int j = i; j < n; ++j) {
                                // check substring is non-repeating
                                if(isDistinct(s, i , j)) {
                                        maxLen = Math.max(j - i + 1, maxLen);
                                }
                        }
                }
                return maxLen;
        }
        
        public static void main(String[] args) {
                
                String str = "abcabcbb";
                System.out.printf("Longest Substring without repeating characters = %d ", longestSubstring(str));
        }
}
