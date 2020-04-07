/*
Construction of Segment Tree.....

Time Complexity : O(n)
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

	int constructSegmentTree( int arr[], int ss, int se, int index)
	{
		if(ss == se)
		{
			st[index] = arr[ss];

			return arr[ss];
		}

		int mid = ss + (se - ss)/2;

		st[index] = constructSegmentTree( arr, ss, mid, index*2 + 1) + 
					constructSegmentTree( arr, mid+1, se, index*2 + 2);

		return st[index];
	}

	void printSegmentTree()
	{
		for(int i=0; i < max_size; ++i)
			System.out.print( st[i] + ", ");
	}

	public static void main(String args[])
	{
		int arr[] = {1, 3, 5, 7, 9, 11};

		int n = arr.length;

		SegmentTree ob = new SegmentTree(arr, n);

		ob.printSegmentTree();
	}
}