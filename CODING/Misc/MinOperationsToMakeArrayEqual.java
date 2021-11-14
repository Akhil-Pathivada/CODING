/**
 * https://leetcode.com/problems/minimum-operations-to-make-array-equal/
 *
 * Time Complexity : O(1)
 * */
package misc;

public class MinOperationsToMakeArrayEqual {
        
        private static int minOperations(int n) {
                
                int mid = n / 2;
                return mid * (mid + n % 2);
        }
        
        public static void main(String[] args) {
                
                int arr[] = {1, 3, 5};
                System.out.println("Minimum operations to make array equal = " + minOperations(arr.length));
        }
}
