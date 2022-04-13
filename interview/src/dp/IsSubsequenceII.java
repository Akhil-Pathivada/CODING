/**
 * Date 11/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/is-subsequence/
 *
 * Time Complexity : O(m)
 * Space Complexity : O(1)
 */
package dp;

public class IsSubsequenceII {
        
        private static boolean isSubsequence(char[] s, char[] t, int m, int n) {
                if(m == 0) {
                        return true;
                }
                int indexS = 0, indexT = 0;
                while(indexT < n) {
                        if(s[indexS] == t[indexT]){
                                ++indexS;
                                if(indexS == m) {
                                        return true;
                                }
                        }
                        ++indexT;
                }
                return false;
        }
        
        public static void main(String[] args) {
                String s ="abc", t = "ahbgdc";
                System.out.println(isSubsequence(s.toCharArray(), t.toCharArray(), s.length(), t.length()));
        }
}
