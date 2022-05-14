/**
 * Date 06/04/2022
 *
 * @author akhilpathivada
 *
 * Insert a Key in the Max Heap
 *
 * Time Complexity : O(log(N))
 * Space Complexity : O(1)
 *
 */
package heap.base.maxheap;

import java.util.Arrays;

public class InsertKeyInMaxHeap {
        private static int[] insertKey(int[] nums, int key, int size) {
                // base case
                if (size < 1) {
                        System.out.println("Error");
                }
                // since we are inserting a new element : create a new heap with size increased by 1
                // copy the original heap into it
                int[] newNums = Arrays.copyOf(nums, size + 1);
                // call IncreaseKey on the last element of new heap
                IncreaseKeyInMaxHeap.increaseKey(newNums, size, key, size + 1);
                return newNums;
        }
        public static void main(String[] args) {
                int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
                BuildMaxHeap.buildMaxHeap(nums, nums.length);
                System.out.printf("Initial MaxHeap : %s ", Arrays.toString(nums));
                int key = 10; // new key
                nums = insertKey(nums, key, nums.length);
                System.out.printf("After Increase Key, MaxHeap : %s ", Arrays.toString(nums));
        }
}
