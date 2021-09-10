class Max_heap
{
	static void PrintHeap(int arr[],int n)
	{
		for(int i=0;i<n;i++)
			System.out.print("  "+arr[i]);
		System.out.println();
	}
	static void Swap(int arr[],int i,int largest)
	{
		int temp=arr[i];
		arr[i]=arr[largest];
		arr[largest]=temp;
	}
	static void Heapify(int arr[],int i,int n)
	{
		int largest;
		int left=2*i+1;
		int right=2*i+2; // left & right children
		if(left<n && arr[left] > arr[i])
			largest=left;
		else largest=i;
	
		if(right<n && arr[right]>arr[largest])
			 largest=right;
		if(largest!=i)
		{
			Swap(arr,i,largest);
			Heapify(arr,largest,n);
		}
	}
	public static void main(String args[])
	{
		int arr[]={2,5,4,7,1,9,3,32,23};
		System.out.println("\n Initial Heap : ");
		int n=arr.length;
		PrintHeap(arr,n);
		Max_heap ob=new Max_heap();
		System.out.println(" MAX Heap : ");
		for(int i=(n/2)-1;i>=0;i--)
		{
			ob.Heapify(arr,i,n);
		}
		PrintHeap(arr,n);
	}
}