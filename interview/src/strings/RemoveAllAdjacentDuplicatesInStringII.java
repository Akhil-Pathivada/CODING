/**
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * */

package strings;

public class RemoveAllAdjacentDuplicatesInStringII {
        
        private static String removeDuplicates(String s, int k) {
                // maintains frequency of a char
                int count = 1;
                for(int i = 1; i < s.length(); ++i) {
                        
                        if(s.charAt(i) == s.charAt(i-1)) {
                                ++count;
                        }
                        else {
                                count = 1;
                        }
                        // if k adjacent same chars encountered
                        if(count == k) {
                                String reduced = s.substring(0, i - k + 1) + s.substring(i + 1);
                                return removeDuplicates(reduced, k);
                        }
                }
                return s;
        }
        
        public static void main(String[] args) {
                
                String s1 = "pbbcggttciiippooaais";
                int k1 = 2;
                System.out.println(removeDuplicates(s1, k1));
                
                String s2 = "deeedbbcccbdaa";
                int k2 = 3;
                System.out.println(removeDuplicates(s2, k2));
        }
}
