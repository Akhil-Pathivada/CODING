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
import java.util.Collections;
import java.util.Comparator;

public class TrainsAndPlatforms {
        
        private int minTrains(int[][] arr) {
                Arrays.sort(arr, new Comparator<int[]>() {
                                @Override
                                public int compare(int[] o1, int[] o2) {
                                        return o1[0] - o2[0];
                                }
                        }
                );
                int n = arr.length;
                return n;
                
        }
        
        public static void main(String[] args) {
                int arr[][] = {
                        { 120, 130 },
                        { 130, 150 },
                        { 125, 145 },
                        { 150, 180 }
                };
                System.out.println("Minimum Number of Platforms Required =  "+ new TrainsAndPlatforms().minTrains(arr));
        }
}
