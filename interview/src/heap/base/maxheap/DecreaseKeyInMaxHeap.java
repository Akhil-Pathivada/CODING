/**
 * Date 06/04/2022
 *
 * @author akhilpathivada
 *
 * Decrease a Key in the Max Heap
 *
 * Time Complexity : O(log(N))
 * Space Complexity : O(log(N))
 */
package heap.base.maxheap;

import java.util.Arrays;

public class DecreaseKeyInMaxHeap {
        private static void decreaseKey(int[] nums, int index, int newValue, int size) {
                // base case
                if (size < 1) {
                        System.out.println("Error");
                }
                // replace key with new value
                nums[index] = newValue;
                // apply heapify on it
                BuildMaxHeap.maxHeapify(nums, index, size);
        }
        public static void main(String[] args) {
                int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
                BuildMaxHeap.buildMaxHeap(nums, nums.length);
                System.out.printf("Initial MaxHeap : %s ", Arrays.toString(nums));
                int originalKeyIndex = 0; // index of the key to be increased
                int newKey = -1; // new value
                decreaseKey(nums, originalKeyIndex, newKey, nums.length);
                System.out.printf("After Decrease Key, MaxHeap : %s ", Arrays.toString(nums));
        }
}
