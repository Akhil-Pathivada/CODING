/**
 * Date 06/04/2022
 *
 * @author akhilpathivada
 *
 * Build the Min Heap....
 *
 * Time Complexity : O(N)
 * Space Complexity : O(log(N))
 *
 */
package heap.base.minheap;

import java.util.Arrays;

public class BuildMinHeap {
        
        private static void swap(int[] nums, int i, int j) {
                
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
        }
        
        public static void minHeapify(int[] nums, int index, int size) {
                
                int smallest = index;
                int left = (2 * index) + 1; // left child
                int right = (2 * index) + 2; // right child
                // check if children are smaller than root
                if(left < size && nums[left] < nums[smallest]) {
                        smallest = left;
                }
                if(right < size && nums[right] < nums[smallest]) {
                        smallest = right;
                }
                // swap if children are smaller than root
                // and call heapify on children
                if(smallest != index) {
                        swap(nums, smallest, index);
                        minHeapify(nums, smallest, size);
                }
        }
        
        public static void buildMinHeap(int[] nums, int size) {
                // call heapify starting from last non-leaf node to root
                for(int i = (size/2) - 1; i >= 0; --i) {
                        minHeapify(nums, i, size);
                }
        }
        
        public static void main(String[] args) {
                
                int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1};
                
                buildMinHeap(nums, nums.length);
                
                System.out.printf("MaxHeap : %s ", Arrays.toString(nums));
        }
}
