/**
 * Date 06/04/2022
 *
 * @author akhilpathivada
 *
 * Increase a Key in the Max Heap
 *
 * Time Complexity : O(log(N))
 * Space Complexity : O(1)
 *
 */
package heap.base.maxheap;

import java.util.Arrays;

public class IncreaseKeyInMaxHeap {
        private static void swap(int[] nums, int i, int j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
        }
        public static void increaseKey(int[] nums, int index, int newValue, int size) {
                // base case
                if (size < 1) {
                        System.out.println("Error");
                }
                // replace key with new value
                nums[index] = newValue;
                // check child is greater than parent
                while (index >= 0 && nums[index] > nums[(index - 1) / 2]) {
                        // swap parent and child
                        swap(nums, index, (index - 1) / 2);
                        index = (index - 1) / 2;
                }
        }
        public static void main(String[] args) {
                int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
                BuildMaxHeap.buildMaxHeap(nums, nums.length);
                System.out.printf("Initial MaxHeap : %s ", Arrays.toString(nums));
                int originalKeyIndex = 7; // index of the key to be increased
                int newKey = 10; // new value
                increaseKey(nums, originalKeyIndex, newKey, nums.length);
                System.out.printf("After Increase Key, MaxHeap : %s ", Arrays.toString(nums));
        }
}
