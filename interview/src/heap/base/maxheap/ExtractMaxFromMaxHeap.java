/**
 * Date 06/04/2022
 *
 * @author akhilpathivada
 *
 * Extract the Maximum element from the Max Heap
 *
 * Time Complexity : O(log(N))
 * Space Complexity : O(log(N))
 *
 */
package heap.base.maxheap;

import java.util.Arrays;

public class ExtractMaxFromMaxHeap {
        private static int extractMax(int[] nums, int size) {
                // base case
                if (size < 1) {
                        return Integer.MIN_VALUE;
                }
                // max element is at root in maxheap
                int maxElement = nums[0];
                // make last element as root
                nums[0] = nums[size - 1];
                // delete the last element
                --size;
                // call heapify on root
                BuildMaxHeap.maxHeapify(nums, 0, size);
                return maxElement;
        }
        public static void main(String[] args) {
                int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
                BuildMaxHeap.buildMaxHeap(nums, nums.length);
                System.out.printf("Initial MaxHeap : %s ", Arrays.toString(nums));
                System.out.printf("Max element is = %d ", extractMax(nums, nums.length));
                // max heap after extraction
                // nums = Arrays.copyOf(nums, nums.length - 1);
                // System.out.printf("After extracting max, MaxHeap : %s ", Arrays.toString(nums));
        }
}
