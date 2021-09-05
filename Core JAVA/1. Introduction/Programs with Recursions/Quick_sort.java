// Sorting using Quick sort
class Quick_sort
{
	public static int Partition(int arr[],int low,int high)
	{
		int x=arr[high];
		int i=low-1;
		for(int j=low;j<=high-1;j++)
		{
			if(arr[j]<=x)
			{
				i++;
				// Swapping (arr[i],arr[j]);
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		// Swapping (arr[i+1],arr[high]);
		int temp=arr[i+1];
		arr[i+1]=arr[high];
		arr[high]=temp;
		return (i+1);
	}
	public static void Sort(int arr[],int low,int high)
	{
		if(low<high)
		{
			int pivot=Partition(arr,low,high);
			Sort(arr,low,pivot-1);
			Sort(arr,pivot+1,high);
		}
	}
	public static void main(String args[])
	{
		int arr[]={3,7,1,5,6,10,11,34,21,56,33};
		Quick_sort ob=new Quick_sort();
		int n=arr.length-1;
		System.out.println("\n The intial array : ");
		for(int i=0;i<=n;i++)
		{
			System.out.print("  "+arr[i]);
		}
		ob.Sort(arr,0,n);
		System.out.println("\n The sorted array : ");
		for(int i=0;i<=n;i++)
		{
			System.out.print("  "+arr[i]);
		}
		System.out.println();
	}
}