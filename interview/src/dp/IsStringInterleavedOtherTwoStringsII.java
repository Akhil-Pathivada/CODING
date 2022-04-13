/**
 * Date 13/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/find-if-a-string-is-interleaved-of-two-other-strings-dp-33/
 * https://leetcode.com/problems/interleaving-string/
 *
 * Time Complexity : O(m * n)
 * Space Complexity : O(m * n)
 *
 */
package dp;

public class IsStringInterleavedOtherTwoStringsII {
        
        private boolean isInterleaved(String A, String B, String C) {
                
                int m = A.length(), n = B.length(), k = C.length();
                // C can be an interleaving of A and B only if the sum of lengths of A and B
                // is equal to length of C
                if(m + n != k) {
                        return false;
                }
                boolean[][] table = new boolean[m + 1][n + 1];
                return table[m][n];
        }
        
        public static void main(String[] args) {
                
                IsStringInterleavedOtherTwoStringsII obj = new IsStringInterleavedOtherTwoStringsII();
                System.out.println(obj.isInterleaved("XXY", "XXZ", "XXZXXXY"));
                System.out.println(obj.isInterleaved("XY", "WZ", "WZXY"));
                System.out.println(obj.isInterleaved("XY", "X", "XXY"));
                System.out.println(obj.isInterleaved("YX", "X", "XXY"));
                System.out.println(obj.isInterleaved("XXY", "XXZ", "XXXXZY"));
        }
}
