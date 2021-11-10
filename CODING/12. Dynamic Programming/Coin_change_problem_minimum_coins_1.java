/*
Given a value V, if we want to make a change for V cents, and we have an infinite supply of each of C = { C1, C2, .., Cm} valued coins, what is the minimum number of coins to make the change? If it’s not possible to make a change, print -1.

Input: coins[] = {25, 10, 5}, V = 30
Output: Minimum 2 coins required
We can use one coin of 25 cents and one of 5 cents 

Input: coins[] = {9, 6, 5, 1}, V = 11
Output: Minimum 2 coins required
We can use one coin of 6 cents and 1 coin of 5 cents

Time Complexity : Exponential

*/

class GFG {

	private static int minCoins(int[] coins, int n, int V) {

		if(V == 0) {
			return 0;
		}
		int res = Integer.MAX_VALUE;

		// Try every coin that has smaller value than V
		for(int i = 0; i < n; ++i) {

			if(coins[i] <= V) {

				int sub_res = minCoins(coins, n, V - coins[i]);

				if(sub_res != Integer.MAX_VALUE && sub_res + 1 < res) { 
					res = sub_res + 1;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
	
		int coins[] =  {9, 6, 5, 1};
		int n = coins.length;
		int V = 11;

		System.out.println("Minimum coins required is " + minCoins(coins, n, V));
	}
}