/**
 * Date 01/05/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/minimum-number-deletions-insertions-transform-one-string-another/
 *
 * Time Complexity : O(m * n)
 * Space Complexity : O(m * n)
 */
package dp;

public class MinimumInsertionsDeletionsToConvertStringAToStringB {
        // find the longest common subsequence
        private int LCS(String X, String Y, int m, int n) {
                int[][] table = new int[m + 1][n + 1];
                for (int i = 0; i <= m; ++i) {
                        for (int j = 0; j <= n; ++j) {
                                if (i == 0 || j == 0) {
                                        table[i][j] = 0;
                                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                                        table[i][j] = 1 + table[i - 1][j - 1];
                                } else {
                                        table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
                                }
                        }
                }
                return table[m][n];
        }
        
        private void minimumInsertionsDeletions(String str1, String str2) {
                int m = str1.length();
                int n = str2.length();
                int lengthOfLCS = LCS(str1, str2, m, n);
                System.out.printf("Minimum number of deletions = %d ", m - lengthOfLCS);
                System.out.printf("Minimum number of insertions = %d", n - lengthOfLCS);
        }
        
        public static void main(String[] args) {
                String str1 = new String("heap");
                String str2 = new String("pea");
                new MinimumInsertionsDeletionsToConvertStringAToStringB().minimumInsertionsDeletions(str1, str2);
        }
}
