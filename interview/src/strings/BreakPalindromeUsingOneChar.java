/**
 * https://leetcode.com/problems/break-a-palindrome/
 *
 * Time Complexity : O(N)
 * */
package strings;

public class BreakPalindromeUsingOneChar {
        
        private static String breakPalindrome(String palindrome) {
                
                char[] p = palindrome.toCharArray();
                int n = palindrome.length();
                // if given string is 'a' or like that
                if(n == 1) {
                        return "IMPOSSIBLE";
                }
                for(int i = 0; i < n; ++i) {
                        // get corresponding palindromic char of p[i]
                        int j = n - i - 1;
                        // when n is odd, we cant do this operation
                        if(i == j) {
                                continue;
                        }
                        if(p[i] != 'a') {
                                p[i] = 'a';
                                return String.valueOf(p);
                        }
                }
                // if given string is all a's
                p[n - 1] = 'b';
                return String.valueOf(p);
        }
        
        public static void main(String[] args) {
                
                String palindrome = "abccba";
                System.out.println(breakPalindrome(palindrome));
        }
}
