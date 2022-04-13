/**
 * Date 13/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/longest-common-substring-dp-29/
 *
 * Time Complexity : O(m * n)
 * Space Complexity : O(m * n)
 */
package dp;

public class LongestCommonSubstringII {
        
        private int LCS(char[] X, char[] Y, int m, int n) {
                // base case
                if(m == 0 || n == 0) {
                        return 0;
                }
                int table[][] = new int[m + 1][n + 1];
                // store length of the longest common substring
                int count = 0;
                for(int i = 0; i <= m; ++i) {
                        for(int j = 0; j <= n; ++j) {
                                if(i == 0 || j == 0) {
                                        table[i][j] = 0;
                                }
                                else if(X[i - 1] == Y[j - 1]) {
                                        table[i][j] = 1 + table[i - 1][j - 1];
                                        count = Math.max(count, table[i][j]);
                                }
                                else {
                                        table[i][j] = 0;
                                }
                        }
                }
                return count;
        }
        
        public static void main(String[] args) {
                String X = "OldSite:GeeksforGeeks.org";
                String Y = "NewSite:GeeksQuiz.com";
                System.out.println(new LongestCommonSubstringII().LCS(X.toCharArray(), Y.toCharArray(), X.length(), Y.length()));
        }
}
