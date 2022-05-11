/**
 * Date 11/05/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/k-closest-points-to-origin/
 *
 * Time Complexity : O(N * log(N)) -> for sorting
 * Space Complexity : O(N) -> space needed for sorting
 */
package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class KClosestPointsToOrigin {
        private int[][] kClosest(int[][] points, int k) {
                Arrays.sort(points, Comparator.comparing(p -> p[0] * p[0] + p[1] * p[1]));
                return Arrays.copyOfRange(points, 0, k);
        }
        public static void main(String[] args) {
                int[][] points = {
                        { 1, 3 },
                        { -2, 2 }
                };
                int k = 1;
                System.out.println(Arrays.deepToString(new KClosestPointsToOrigin().kClosest(points, k)));
        }
}
