class Bubble_sort
{
	public static void Sort(int arr[],int n)
	{
		if(n==1) 
			return;

		for(int i=0;i<n-1;i++) 
		{
			if(arr[i]>arr[i+1]) 
			{
				int temp=arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=temp;
			}
		}
		Sort(arr,n-1);
	}

	public static void main(String args[])
	{
		int arr[]={4,1,2,7,5,9,3};

		int n=arr.length;

		for(int i=0;i<n;i++)
			System.out.print("  "+arr[i]);

		Sort(arr,n);

		System.out.println(" \n The sorted array : ");

		for(int i=0;i<n;i++)
			System.out.print("  "+arr[i]);
	}
}
