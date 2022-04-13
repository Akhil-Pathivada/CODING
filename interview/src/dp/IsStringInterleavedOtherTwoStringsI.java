/**
 * Date 13/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/find-if-a-string-is-interleaved-of-two-other-strings-dp-33/
 * https://leetcode.com/problems/interleaving-string/
 *
 * Time Complexity : O(2 ^ (m + n))
 * Space Complexity : O(m + n)
 *
 */
package dp;

public class IsStringInterleavedOtherTwoStringsI {
        
        private boolean isInterleavedUtil(String A, String B, String C, int m, int n, int k) {
                // base case: If all strings are empty
                if(m == 0 && n == 0 && k == 0) {
                        return true;
                }
                // If C is empty and any of the two strings is not empty
                if(k == 0) {
                        return false;
                }
                // If any of the above mentioned two possibilities is true,
                // then return true, otherwise false
                return ((m > 0 && A.charAt(m - 1) == C.charAt(k - 1) && isInterleavedUtil(A, B, C, m - 1, n, k - 1)) ||
                        (n > 0 && B.charAt(n - 1) == C.charAt(k - 1) && isInterleavedUtil(A, B, C, m, n - 1, k - 1))
                        );
        }
        
        private boolean isInterleaved(String A, String B, String C) {
                return isInterleavedUtil(A, B, C, A.length(), B.length(), C.length());
        }
        
        public static void main(String[] args) {
                IsStringInterleavedOtherTwoStringsI obj = new IsStringInterleavedOtherTwoStringsI();
                System.out.println(obj.isInterleaved("XXY", "XXZ", "XXZXXXY"));
                System.out.println(obj.isInterleaved("XY", "WZ", "WZXY"));
                System.out.println(obj.isInterleaved("XY", "X", "XXY"));
                System.out.println(obj.isInterleaved("YX", "X", "XXY"));
                System.out.println(obj.isInterleaved("XXY", "XXZ", "XXXXZY"));
        }
}
