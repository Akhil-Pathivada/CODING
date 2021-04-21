/*
We have an array arr[0 . . . n-1]. 
We should be able to efficiently find the minimum value 
from index qs (query start) to qe (query end) where 0 <= qs <= qe <= n-1.

Time Complexity : O(log N)
Space Complexity : O(n)

*/
class SegmentTree
{
	int st[]; // This array stores Segement Tree nodes

	int max_size; // Size of Segment Tree

	SegmentTree( int arr[], int n)
	{
		int x = (int)(Math.ceil(Math.log(n)/Math.log(2)));

		max_size = 2 * (int) Math.pow(2, x) - 1;

		st = new int[max_size];

		constructSegmentTree(arr, 0, n-1, 0);
	}

	int Min( int a, int b)
	{
		return a < b ? a : b;
	}

	int constructSegmentTree( int arr[], int ss, int se, int index)
	{
		if(ss == se)
		{
			st[index] = arr[ss];

			return arr[ss];
		}

		int mid = ss + (se - ss)/2;

		st[index] = Min(constructSegmentTree( arr, ss, mid, index*2 + 1),
						constructSegmentTree( arr, mid+1, se, index*2 + 2));

		return st[index];
	}

	int minInRangeUtil( int ss, int se, int qs, int qe, int index)
	{
		if(qs <= ss && qe >= se)
			return st[index];

		if(se < qs || ss > qe)
			return Integer.MAX_VALUE;

		int mid = ss + (se - ss)/2;

		return Min( minInRangeUtil(ss, mid, qs, qe, 2*index + 1), 
					minInRangeUtil(mid+1, se, qs, qe, 2*index + 2));
	}

	int minInRange( int n, int qs, int qe)
	{
		if( qs < 0 || qs >= n)
			return -1;

		return minInRangeUtil(0, n-1, qs, qe, 0);
	}

	void printSegmentTree()
	{
		for(int i=0; i < max_size; ++i)
			System.out.print( st[i] + ", ");
	}

	public static void main(String args[])
	{
		int arr[] = {2, 5, 1, 4, 9, 3};

		int n = arr.length;

		SegmentTree ob = new SegmentTree(arr, n);

		System.out.println("Min. of values in given Range = " + ob.minInRange(n, 1, 4));
	}
}