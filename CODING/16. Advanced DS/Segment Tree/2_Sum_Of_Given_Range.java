/* 
Find the sum of elements from index l to r where 0 <= l <= r <= n-1

Time Complexity : O(log N)
Space Complexity : O(n)
*/

class SegmentTree
{
	int st[]; // This array stores Segement Tree nodes

	SegmentTree( int arr[], int n)
	{
		int x = (int)(Math.ceil(Math.log(n)/Math.log(2)));

		int max_size = 2 * (int) Math.pow(2, x) - 1;

		st = new int[max_size];

		constructSegmentTree(arr, 0, n-1, 0);
	}

	int getMid( int s, int e)
	{
		return s + (e - s)/2;
	}

	int constructSegmentTree( int arr[], int ss, int se, int index)
	{
		if(ss == se)
		{
			st[index] = arr[ss];

			return arr[ss];
		}

		int mid = getMid(ss, se);

		st[index] = constructSegmentTree( arr, ss, mid, index*2 + 1) + 
					constructSegmentTree( arr, mid+1, se, index*2 + 2);

		return st[index];
	}

	int getSumUtil( int ss, int se, int qs, int qe, int index)
	{
		if( qs <= ss && qe >= se)
			return st[index];

		if( ss > qe || se < qs)
			return 0;

		int mid = getMid(ss, se);

		return 	getSumUtil( ss, mid, qs, qe, 2*index + 1) + 
				getSumUtil( mid+1, se, qs, qe, 2*index + 2);
	}

	int getSum( int n, int qs, int qe)
	{
		if( qs < 0 || qe > n-1 || qs > qe)
			return -1;

		return getSumUtil( 0, n-1, qs, qe, 0);		
	}

	public static void main(String args[])
	{
		int arr[] = {1, 3, 5, 7, 9, 11};

		int n = arr.length;

		SegmentTree ob = new SegmentTree(arr, n);

		System.out.println("Sum of values in given range = " + ob.getSum( n, 1, 4));
	}
}