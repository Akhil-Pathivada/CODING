/**
 * Date 06/04/2022
 *
 * @author akhilpathivada
 *
 * Build the Max Heap....
 *
 * Time Complexity : O(N)
 * Space Complexity : O(log(N))
 *
 */
package heap.base.maxheap;

import java.util.Arrays;

public class BuildMaxHeap {
        private static void swap(int[] nums, int i, int j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
        }
        public static void maxHeapify(int[] nums, int index, int size) {
                int largest = index;
                int left = (2 * index) + 1; // left child
                int right = (2 * index) + 2; // right child
                // check if children are bigger than root
                if (left < size && nums[left] > nums[largest]) {
                        largest = left;
                }
                if (right < size && nums[right] > nums[largest]) {
                        largest = right;
                }
                // swap if children are bigger than root
                // and call heapify on children
                if (largest != index) {
                        swap(nums, largest, index);
                        maxHeapify(nums, largest, size);
                }
        }
        public static void buildMaxHeap(int[] nums, int size) {
                // call heapify starting from last non-leaf node to root
                for (int i = (size / 2) - 1; i >= 0; --i) {
                        maxHeapify(nums, i, size);
                }
        }
        
        public static void main(String[] args) {
                int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
                buildMaxHeap(nums, nums.length);
                System.out.printf("MaxHeap : %s ", Arrays.toString(nums));
        }
}
