/**
 * Date 12/04/2022
 *
 * @author akhilpathivada
 *
 * Write a program to print all the LEADERS in the array. An element is leader if it is greater than all the elements to its right side.
 * And the rightmost element is always a leader. For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package array;

public class LeadersInArray {
        
        private void leaders(int[] arr) {
                int n = arr.length;
                int maxOnRight = arr[n - 1];
                System.out.println(maxOnRight);
                for (int i = n - 2; i >= 0; --i) {
                        if (arr[i] >= maxOnRight) {
                                maxOnRight = arr[i];
                                System.out.println(arr[i]);
                        }
                }
        }
        
        public static void main(String[] args) {
                int[] arr = { 16, 17, 4, 3, 5, 2 };
                new LeadersInArray().leaders(arr);
        }
}
