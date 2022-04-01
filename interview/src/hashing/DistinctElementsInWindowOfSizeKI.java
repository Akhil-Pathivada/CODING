/**
 * Date 01/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/count-distinct-elements-in-every-window-of-size-k/
 *
 * Time Complexity : O(N * (K ^ 2))
 * Space Complexity : O(1)
 */
package hashing;

public class DistinctElementsInWindowOfSizeKI {
        
        private static void countDistinct(int[] arr, int k) {
        
                int n = arr.length;
                for(int i = 0; i <= n - k; ++i) {
                        
                        int dcount = 0;
                        for(int j = 0; j < k; ++j) {
                                
                                boolean found = false;
                                for(int m = i + j; m < k; ++m) {
                                        
                                        if(j != m && arr[i + j] == arr[i + m]) {
                                                found = true;
                                        }
                                }
                                if(!found) {
                                        ++dcount;
                                }
                        }
                        System.out.print(dcount + ", ");
                }
        }
        
        public static void main(String[] args) {
                
                int arr[] = { 1, 2, 1, 3, 4, 2, 3 }, k = 4;
                countDistinct(arr, k);
        }
}
