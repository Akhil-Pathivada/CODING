/*
Given a value V, if we want to make a change for V cents, and we have an infinite supply of each of C = { C1, C2, .., Cm} valued coins, what is the minimum number of coins to make the change? If it’s not possible to make a change, print -1.

Input: coins[] = {25, 10, 5}, V = 30
Output: Minimum 2 coins required
We can use one coin of 25 cents and one of 5 cents 

Input: coins[] = {9, 6, 5, 1}, V = 11
Output: Minimum 2 coins required
We can use one coin of 6 cents and 1 coin of 5 cents

Time Complexity : O(n * V)
Space Complexity : O(V)

*/

class GFG {

	private static int minCoins(int[] coins, int n, int V) {

		// table[i] will be storing the minimum number of coins
    		// required for i value.  So table[V] will have result
		int table[] = new int[V + 1];
		table[0] = 0;

		// Initialize all table values as Infinite
		for(int i = 1; i <= V; ++i) {
			table[i] = Integer.MAX_VALUE;
		}
		
		// Compute minimum coins required for all values from 1 to V
		for(int i = 0; i <= V ; ++i) {

			for(int j = 0; j < n; ++j) {
				// Go through all coins smaller than i
				if(coins[j] <= i) {

					int sub_res = table[i - coins[j]];

					if(sub_res != Integer.MAX_VALUE && sub_res + 1 < table[i]) {
						table[i] = sub_res + 1;
					}
				}
			}
		}

		return (table[V] == Integer.MAX_VALUE) ? -1 : table[V];
	}

	public static void main(String[] args) {
	
		int coins[] =  {9, 6, 5, 1};
		int n = coins.length;
		int V = 11;

		System.out.println("Minimum coins required is " + minCoins(coins, n, V));
	}
}