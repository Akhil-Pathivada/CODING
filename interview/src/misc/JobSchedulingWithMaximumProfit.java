/**
 * https://leetcode.com/problems/maximum-profit-in-job-scheduling/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * */


package misc;

import java.util.Arrays;
import java.util.TreeMap;

public class JobSchedulingWithMaximumProfit {
        
        private int maxProfit(int[] startTime, int[] endTime, int[] profit) {
                int n = startTime.length;
                int[][] jobs = new int[n][3];
                // put start, end, profits in a 2d array
                for (int i = 0; i < n; ++i) {
                        jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
                }
                // sort based upon end times
                Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
                // compute the results inside TreeMap
                // because since TreeMap always stores in sorted order
                // fetching an element takes only log(N)
                TreeMap<Integer, Integer> dp = new TreeMap<>();
                dp.put(0, 0);
                for (int[] job : jobs) {
                        // get the previous end time
                        int val = job[2] + dp.floorEntry(job[0]).getValue();
                        // add the current job only if it is
                        // going to increase profit
                        if (val > dp.lastEntry().getValue()) {
                                dp.put(job[1], val);
                        }
                }
                return dp.lastEntry().getValue();
        }
        
        public static void main(String[] args) {
                int[] startTime = {1, 2, 3, 4, 6};
                int[] endTime = {3, 5, 10, 6, 9};
                int[] profit = {20, 20, 100, 70, 60};
                System.out.println(new JobSchedulingWithMaximumProfit().maxProfit(startTime, endTime, profit));
        }
}
