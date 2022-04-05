/**
 * Date 05/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/frequency-substring-string/
 *
 * Time Complexity : O(N * M)
 * Space Complexity : O(1)
 */
package patternmatch;

public class FrequencyOfSubstringInAStringI {
        
        private static int countFrequency(String pattern, String text) {
                
                int M = pattern.length();
                int N = text.length();
                int result = 0;
                // A loop to slide pattern[] one by one
                for(int i = 0; i <= N - M; ++i) {
                        // For current index i, check for pattern match
                        int j;
                        for(j = 0; j < M; ++j) {
                                
                                if(text.charAt(i + j) != pattern.charAt(j)) {
                                        break;
                                }
                        }
                        // matched
                        if(j == M) {
                                ++result;
                        }
                }
                return result;
        }
        
        public static void main(String[] args) {
        
                String text = "dhimanman";
                String pattern = "man";
                System.out.println(countFrequency(pattern, text));
        }
}
