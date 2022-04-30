/**
 * Date 19/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/find-the-number-occurring-odd-number-of-times/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package misc;

public class OddOccurance {
        
        private int oddOccurance(int[] nums) {
                int result = 0;
                for (int num : nums) {
                        result ^= num;
                }
                return result;
        }
        
        public static void main(String[] args) {
                int[] nums = { 2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2 };
                System.out.println(new OddOccurance().oddOccurance(nums));
        }
}
