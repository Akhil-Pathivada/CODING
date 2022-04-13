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
                for(int i = 0; i <=m; ++i) {
                        for(int j = 0; j <= n; ++j) {
                                if(i == 0 && j == 0) {
                                        table[i][j] = true;
                                }
                                // if 'A' is empty
                                else if(i == 0) {
                                        if(B.charAt(j - 1) == C.charAt(j - 1)) {
                                                table[i][j] = table[i][j - 1];
                                        }
                                }
                                // if 'B' is empty
                                else if(j == 0) {
                                        if(A.charAt(i - 1) == C.charAt(i - 1)) {
                                                table[i][j] = table[i - 1][j];
                                        }
                                }
                                // Current character of C matches with current character of A,
                                // but doesn't match with current character if B
                                else if(A.charAt(i - 1) == C.charAt(i + j - 1) && B.charAt(j - 1) != C.charAt(i + j - 1)) {
                                        table[i][j] = table[i - 1][j];
                                }
                                // Current character of C matches with current character of B, but
                                // doesn't match with current character if A
                                else if(B.charAt(j - 1) == C.charAt(i + j - 1) && A.charAt(i - 1) != C.charAt(i + j - 1)) {
                                        table[i][j] = table[i][j - 1];
                                }
                                // Current character of C matches with that of both A and B
                                else if(A.charAt(i - 1) == C.charAt(i + j- 1) && B.charAt(j - 1) == C.charAt(i + j - 1)) {
                                        table[i][j] = table[i - 1][j] || table[i][j - 1];
                                }
                        }
                }
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
