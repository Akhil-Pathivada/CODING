class Insertion_sort
{
	static void PrintArray(int arr[],int n)
	{
		for(int i=0;i<n;i++) 
			System.out.print("  "+arr[i]);
		System.out.println();
	}
	void Sort(int arr[],int i,int n)
	{
		if(i==n) return;
		int key=arr[i],j;
		for(j=i-1;j>=0 && arr[j]>key;j--)
		{
			arr[j+1]=arr[j];
		}
		arr[j+1]=key;
		Sort(arr,++i,n);
	}
	public static void main(String args[])
	{
		int arr[]={9,5,4,7,8,2,776,3,1,6},key,j;
		System.out.println("\n The intial array : ");
		PrintArray(arr,arr.length);
		Insertion_sort ob=new Insertion_sort();
		ob.Sort(arr,1,arr.length);
		System.out.println("\n The sorted array: ");
		PrintArray(arr,arr.length);
	}
}