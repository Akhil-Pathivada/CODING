/**
 * Date 24/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
 *
 * The above solution may try all subsets of given set in worst case.
 * Therefore time complexity of the above solution is exponential.
 * The problem is in-fact NP-Complete (There is no known polynomial time solution for this problem)
 */
package dp;

public class SubsetSumI {
        
        private boolean isSubsetSum(int[] set, int n, int sum) {
                // base cases
                if (sum == 0) {
                        return true;
                }
                if (n == 0) {
                        return false;
                }
                // if element is greater than sum : exclude it
                if (set[n - 1] > sum) {
                        return isSubsetSum(set, n - 1, sum);
                }
                // else, check if sum can be obtained
                // by any of the following
                // (a) including the last element
                // (b) excluding the last element
                return isSubsetSum(set, n - 1, sum - set[n - 1])
                        || isSubsetSum(set, n - 1, sum);
        }
        
        public static void main(String[] args) {
                int[] set = { 3, 34, 4, 12, 5, 2 };
                int sum = 9;
                System.out.println(new SubsetSumI().isSubsetSum(set, set.length, sum));
        }
}
