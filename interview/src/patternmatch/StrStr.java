/**
 * Date 23/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/implement-strstr/
 *
 * Time Complexity : O(m * n)
 * Space Complexity : O(1)
 */
package patternmatch;

public class StrStr {
        
        private int strStr(String haystack, String needle) {
                for (int i = 0; ; ++i) {
                        for (int j = 0; ; ++j) {
                                if (j == needle.length()) {
                                        return i;
                                }
                                if (i + j == haystack.length()) {
                                        return -1;
                                }
                                if (haystack.charAt(i + j) != needle.charAt(j)) {
                                        break;
                                }
                        }
                }
        }
        
        public static void main(String[] args) {
                String haystack = "hello", needle = "ll";
                System.out.println(new StrStr().strStr(haystack, needle));
        }
}
