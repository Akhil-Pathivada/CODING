/**
 * Date 09/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/job-sequencing-problem/?ref=lbp
 *
 * Time Complexity : O(N ^ 2)
 * Space Complexity : O(N) -> for sorting
 */
package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class JobSequencingProblem {
        
        static class Job {
                // Each job has a unique-id, profit and deadline
                char id;
                int deadline, profit;
                // Constructors
                public Job() {
                }
        
                public Job(char id, int deadline, int profit) {
                        this.id = id;
                        this.deadline = deadline;
                        this.profit = profit;
                }
        }
        
        private void scheduleJobs(ArrayList<Job> arr, int maxDeadline, int n) {
                // Sort all jobs according to decreasing order of profit
                Collections.sort(arr,
                        (a, b) -> b.profit - a.profit);
                // To store result (Sequence of jobs)
                char[] jobs = new char[maxDeadline];
                // To keep track of free time slots
                boolean[] slot = new boolean[maxDeadline];
                for (int i = 0; i < n; ++i) {
                        // since array start with index 0
                        int deadline = arr.get(i).deadline - 1;
                        // Free slot found
                        if (slot[deadline] == false) {
                                // allot the slot
                                slot[deadline] = true;
                                // add this job to result
                                jobs[deadline] = arr.get(i).id;
                        } else {
                                // search for free slots in previous slots
                                for (int j = deadline - 1; j >= 0; --j) {
                                        // Free slot found
                                        if (slot[j] == false) {
                                                // allot the slot
                                                slot[j] = true;
                                                // add this job to result
                                                jobs[j] = arr.get(i).id;
                                                break;
                                        }
                                }
                        }
                }
                // Print the jobs sequence
                System.out.println(Arrays.toString(jobs));
        }
        
        public static void main(String[] args) {
                ArrayList<Job> arr = new ArrayList<Job>();
                arr.add(new Job('a', 2, 100));
                arr.add(new Job('b', 1, 19));
                arr.add(new Job('c', 2, 27));
                arr.add(new Job('d', 1, 25));
                arr.add(new Job('e', 3, 15));
                System.out.println("Following is maximum profit sequence of jobs");
                // since max deadline among all jobs is 3
                int maxDeadline = 3;
                new JobSequencingProblem().scheduleJobs(arr, maxDeadline, arr.size());
        }
}
