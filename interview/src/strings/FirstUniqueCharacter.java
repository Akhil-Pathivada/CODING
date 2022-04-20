/**
 *
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 * */
package strings;

public class FirstUniqueCharacter {
        
        private int firstUniqChar(String s) {
                int freq[] = new int[26];
                // store frequency of character
                for(int i = 0; i < s.length(); ++i) {
                        freq[s.charAt(i) - 'a']++;
                }
                for(int i = 0; i < s.length(); ++i) {
                        // result found
                        if(freq[s.charAt(i) - 'a'] == 1) {
                                return i;
                        }
                }
                return -1;
        }
        
        public static void main(String[] args) {
                String s = new String("loveleetcode");
                System.out.println(new FirstUniqueCharacter().firstUniqChar(s));
        }
}
