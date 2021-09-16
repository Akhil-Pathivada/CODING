/* 
 * Given an array arr[] consisting of N positive integers such that arr[i] represents that the ith bag contains arr[i] diamonds and a positive integer K, the task is to find the maximum number of diamonds that can be gained in exactly K minutes if dropping a bag takes 1 minute such that if a bag with P diamonds is dropped, then it changes to [P/2] diamonds, and P diamonds are gained.
 *
 * Examples:
 *
 * Input: arr[] = {2, 1, 7, 4, 2}, K = 3
 * Output: 14
 * Explanation:
 * The initial state of bags is {2, 1, 7, 4, 2}.
 * Operation 1: Take all diamonds from third bag i.e., arr[2](= 7), the state of bags becomes: {2, 1, 3, 4, 2}.
 * Operation 2: Take all diamonds from fourth bag i.e., arr[3](= 4), the state of bags becomes: {2, 1, 3, 2, 2}.
 * Operation 3: Take all diamonds from Third bag i.e., arr[2](= 3), the state of bags becomes{2, 1, 1, 2, 2}.
 * Therefore, the total diamonds gains is 7 + 4 + 3 = 14.
 *
 * Time Complexity : O((N + K) * log(N))
 * Space Complexity : O(N)
 *
 *  */
import java.util.*;

class GFG { 


	static int maxDiamonds(int A[], int N, int K) {

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

		for(int i = 0; i < N; ++i) {

			maxHeap.add(A[i]);
		}
		
		int result = 0;

		while(!maxHeap.isEmpty() && K-- > 0) {
		
			int top = maxHeap.poll();
			result += top;
			top /= 2;
			maxHeap.add(top);
		}
		return result;
	}

	public static void main(String[] args) {

		int A[] = { 2, 1, 7, 4, 2 };
		int K = 3;
		int N = A.length;

		System.out.println("Maximum diamonds gained in K minutes = " + maxDiamonds(A, N, K));
	}
}
