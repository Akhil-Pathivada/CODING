/* 
 * Given the level order traversal of a Complete Binary Tree, determine whether the Binary Tree is a valid Min-Heap
 * Examples:
 *
 *
 * Input : level = [10, 15, 14, 25, 30]
 * Output : True
 * The tree of the given level order traversal is
 *                      10
 *                     /  \
 *                    15   14
 *                   /  \
 *                  25   30
 * We see that each parent has a value less than
 * its child, and hence satisfies the min-heap
 * property
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 *
 *  */

class GFG { 

	private static boolean isMinHeap(int arr[]) {

		int n = arr.length;
		
		for(int i = (n/2-1); i >= 0; --i) {

			if(arr[i] > arr[2 * i + 1]) {

				return false;
			}
			if(2 * i + 2 < n) {

				if(arr[i] > arr[2 * i + 2]){

					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {

		// Level order traversal
		int[] arr = new int[]{10, 15, 14, 25, 30, 16};

		System.out.println(isMinHeap(arr) ? "True" : "False");
	}	
}
