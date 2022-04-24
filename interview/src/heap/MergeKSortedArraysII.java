/**
 * Date 05/04/2022
 *
 * @author akhilpathivada
 * https://www.geeksforgeeks.org/merge-k-sorted-arrays/
 *
 * Time Complexity : O((K * N) * log(K))
 * Space Complexity : O(K)
 *
 */
package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeKSortedArraysII {
        
        private class MinHeapNode implements Comparable<MinHeapNode> {
                int arr[]; // stores address of each array
                int index; // stores index of an array element
                MinHeapNode(int[] arr, int index) {
                        this.arr = arr;
                        this.index = index;
                }
                @Override
                public int compareTo(MinHeapNode node) {
                        return this.arr[this.index] - node.arr[node.index];
                }
        }
        
        private void mergeArrays(int[][] arr, int[] output, int k, int n) {
                PriorityQueue<MinHeapNode> minHeap = new PriorityQueue<>();
                // inserting first elements of all arrays
                for (int i = 0; i < k; ++i) {
                        minHeap.add(new MinHeapNode(arr[i], 0));
                }
                int c = 0;
                while (!minHeap.isEmpty()) {
                        // poll the min element and add to output
                        MinHeapNode node = minHeap.poll();
                        output[c++] = node.arr[node.index];
                        // Get next element that will replace current root of heap. The next element belongs
                        // to same array as the current root.
                        if (node.index + 1 < node.arr.length) { // add into heap
                                minHeap.add(new MinHeapNode(node.arr, node.index + 1));
                        }
                }
        }
        
        public static void main(String[] args) {
                int[][] arr = {
                        { 2, 6, 12, 34 },
                        { 1, 9, 20, 1000 },
                        { 23, 34, 90, 2000 }
                };
                int k = 3; // k arrays
                int n = 4; // length of each array
                int[] output = new int[k * n];
                new MergeKSortedArraysII().mergeArrays(arr, output, k, n);
                System.out.println(Arrays.toString(output));
        }
}
