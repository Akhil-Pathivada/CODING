class Binary_search
{
	public static void Search(int arr[],int first,int last,int target)
	{
		int mid=(first+last)/2;
		while(first<=last)
		{
			if(arr[mid]==target) 
			{
				System.out.println("\n Target is found at "+mid);
				break;
			}
			else if(target > arr[mid])
				first=mid+1;
			else
				last=mid-1;
			mid=(first+last)/2;
		}
		if(first>last)	 System.out.println("\n Target is not found in the list ");
	}

	public static void main(String args[])
	{
		int arr[]={1,2,3,4,6,7};
		int target=7;
		int last=arr.length-1;
		Search(arr,0,last,target);
	}
}