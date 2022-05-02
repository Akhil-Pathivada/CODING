/**
 * Date 05/04/2022
 *
 * @author akhilpathivada
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementI {
        
        private void computeNGE(int[] arr, int[] nge, int n) {
                Stack<Integer> stack = new Stack<>();
                for (int i = 0; i < n; ++i) {
                        // if a greater element encountered : pop elements smaller to it
                        // and make this current element as their NGE
                        while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                                nge[stack.pop()] = arr[i];
                        }
                        stack.push(i);
                }
        }
        
        public static void main(String[] args) {
                int arr[] = { 6, 8, 0, 1, 3};
                int nge[] = new int[arr.length];
                Arrays.fill(nge, -1);
                new NextGreaterElementI().computeNGE(arr, nge, arr.length);
                System.out.println(Arrays.toString(nge));
        }
}
