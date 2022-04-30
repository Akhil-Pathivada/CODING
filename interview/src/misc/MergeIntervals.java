/**
 * Date 11/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/merge-intervals/
 *
 * Time Complexity : O(N * log(N)) -> sorting
 * Space Complexity : O(N) -> sorting
 */
package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
        
        private int[][] merge(int[][] intervals) {
                int n = intervals.length;
                // Sort by ascending starting point
                Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
                int i = 0;
                // store the result
                List<int[]> result = new ArrayList<>();
                // add the first interval
                result.add(intervals[i]);
                // iterate over all intervals
                for (int j = 1; j < n; ++j) {
                        // overlapping interval found
                        if (intervals[j][0] <= result.get(i)[1]) {
                                // Merge previous and current Intervals
                                result.get(i)[1] = Math.max(result.get(i)[1], intervals[j][1]);
                        } else {
                                result.add(intervals[j]);
                                ++i;
                        }
                }
        
                return result.toArray(new int[result.size()][]);
        }
        
        public static void main(String[] args) {
                int[][] intervals = {
                        {1, 3},
                        {2, 6},
                        {8, 10},
                        {15, 18}
                };
                System.out.println(Arrays.deepToString(new MergeIntervals().merge(intervals)));
                
        }
}
