/**
 * Date 28/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
 *
 * Time Complexity : O(N * log(N))
 * Space Complexity : O(N)
 */
package greedy;

import java.util.Arrays;
public class TrainsAndPlatforms {
        
        private int minTrains(int[]arr, int[] dep) {
                // Sort arrival and departure arrays
                Arrays.sort(arr);
                Arrays.sort(dep);
                // maxPlatformsInUse indicates number of platforms needed at a time
                // platformsNeeded indicates the result
                int maxPlatformsInUse = 1, platformsNeeded = 1;
                // assume first train already took into consideration
                int i = 1, j = 0;
                while (i < arr.length && j < dep.length) {
                        if (arr[i] <= dep[j]) {
                                ++maxPlatformsInUse;
                                ++i;
                        } else if (arr[i] > dep[j]) {
                                --maxPlatformsInUse;
                                ++j;
                        }
                        if (maxPlatformsInUse > platformsNeeded) {
                                platformsNeeded = maxPlatformsInUse;
                        }
                }
                return platformsNeeded;
        }
        
        public static void main(String[] args) {
                int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
                int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
                System.out.println("Minimum Number of Platforms Required =  "+ new TrainsAndPlatforms().minTrains(arr, dep));
        }
}
