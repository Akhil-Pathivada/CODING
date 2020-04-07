/*
The stock span problem is a financial problem where we have a series of n daily price quotes 
for a stock and we need to calculate span of stock’s price for all n days. 

For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, 
then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}

Time Complexity : O(n)
Space Complexity : O(n)
*/

import java.util.*;

class Array
{
	static void calculateSpan( int price[], int stock[], int n)
	{
		Stack<Integer> st = new Stack<>();
		
		for(int i=0; i<n; ++i)
		{
			while(!st.isEmpty() && price[st.peek()] <= price[i])
				st.pop();
			
			stock[i] = st.isEmpty() ? i : (i-st.peek()-1);
			
			st.push(i);
		}
	}
	
	public static void main(String args[])
	{
		int price[] = {10, 2, 3, 15, 22, 9, 25};
		
		int n = price.length;
		
		int stock[] = new int[n];
		
		calculateSpan(price, stock, n);
		
		System.out.print(Arrays.toString(stock));
	}
}
