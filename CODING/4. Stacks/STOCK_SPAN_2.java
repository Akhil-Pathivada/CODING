/* 
Program for Stock Span problem....

https://www.geeksforgeeks.org/the-stock-span-problem/

Time Complexity : O(n)
Space Complexity : O(n)....(for Stack)
*/
import java.util.*;
class GFG {

	private static void calculateSpan(int[] price, int[] S, int n) {

		Stack<Integer> stack = new Stack<>();

		for(int i = 0; i < n; ++i) {

			while(!stack.isEmpty() && price[stack.peek()] <= price[i]) {
				stack.pop();
			}
			S[i] = stack.isEmpty() ? i : (i - stack.peek() - 1);
			stack.push(i);
		}
	}

	public static void main(String[] args) {
		
		int price[] = {100, 80, 60, 70, 60, 75, 85};
		int n = price.length;
		int S[] = new int[n];

		calculateSpan(price, S, n);
		System.out.print(Arrays.toString(S));	
	}
}