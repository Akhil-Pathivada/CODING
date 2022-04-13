/**
 * Date 02/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 *
 */
package slidingwindow;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharactersII {
        
        private static int longestSubstring(String s) {
                
                HashSet<Character> set = new HashSet<>();
                int i = 0, j = 0, maxLength = 0;
                while (j < s.length()) {
                        // first time visiting a character : so include it in max length
                        if(!set.contains(s.charAt(j))) {
                                set.add(s.charAt(j));
                                maxLength = Math.max(set.size(), maxLength);
                                ++j;
                        }
                        else { // already visited the character : so slide the window
                                set.remove(s.charAt(i));
                                ++i;
                        }
                }
                return maxLength;
        }
        
        public static void main(String[] args) {
                
                String str = "abcabcbb";
                System.out.printf("Longest Substring without repeating characters = %d ", longestSubstring(str));
        }
}
