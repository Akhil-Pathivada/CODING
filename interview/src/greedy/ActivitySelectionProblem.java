/**
 * Date 08/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/activity-selection-problem-greedy-algo-1/
 *
 * Time Complexity : O(N * log(N))
 * Space Complexity : O(N)
 *
 */
package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelectionProblem {
        // A job has a start time, finish time and profit.
        static class Activity {
                int start, finish;
                // Constructor
                public Activity(int start, int finish) {
                        this.start = start;
                        this.finish = finish;
                }
        }
        
        private void maxActivities(Activity[] arr, int n) {
                // Sort jobs according to finish time
                Arrays.sort(arr, new Comparator<Activity>() {
                        @Override
                        public int compare(Activity o1, Activity o2) {
                                return o1.finish - o2.finish;
                        }
                });
                // The first activity always gets selected
                int i = 0;
                System.out.print("Following activities are selected : (" + arr[i].start + ", " + arr[i].finish + "), ");
                // Consider rest of the activities
                for (int j = 1; j < n; ++j) {
                        // If this activity has start time greater than or equal to the finish time
                        // of previously selected activity, then select it
                        if (arr[j].start >= arr[i].finish) {
                                i = j;
                                System.out.print("(" + arr[i].start + ", " + arr[i].finish + "), ");
                        }
                }
        }
        
        public static void main(String[] args) {
                int n = 6;
                Activity arr[] = new Activity[n];
                arr[0] = new Activity(5, 9);
                arr[1] = new Activity(1, 2);
                arr[2] = new Activity(3, 4);
                arr[3] = new Activity(0, 6);
                arr[4] = new Activity(5, 7);
                arr[5] = new Activity(8, 9);
                new ActivitySelectionProblem().maxActivities(arr, arr.length);
        }
}
