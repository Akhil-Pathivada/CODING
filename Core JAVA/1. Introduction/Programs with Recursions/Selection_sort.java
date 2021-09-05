//Sorting using Selection sort
class Selection_sort
{
	 static void printArray(int arr[],int n)
    {
        for (int i=0; i<n; i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
	static void Swap(int arr[],int min_ind,int i)
	{
		int temp=arr[min_ind];
		arr[min_ind]=arr[i];
		arr[i]=arr[temp];
	}
	static void Sort(int arr[],int n,int i)
	{
		if(i==n) return;
		int min_ind=i;
		for(int j=i+1;j<n;j++)
		{
			if(arr[j]<arr[min_ind])
				min_ind=j;
		}
		Swap(arr,min_ind,i);
		Sort(arr,n,++i);
	}
	public static void main(String args[])
	{
		int arr[]={10,2,1,12,14};
		System.out.println("\n Initial Array : ");
		printArray(arr,arr.length);
		System.out.println("\n Sorted Array : ");
		Sort(arr,arr.length,0);
		printArray(arr,arr.length);
		
	}
}