class Binary_search
{
	int Search(int arr[],int first ,int last,int target)
	{
			int mid=(first+last)/2;
			if(first<=last)
			{
				if(arr[mid]==target) 
					return mid;
				else if(target > arr[mid])  
					return Search(arr,mid+1,last,target);
				else
					return Search(arr,first,mid-1,target);
			}	 
			return -1;
	}
	public static void main(String args[])
	{
		int arr[]={1,3,4,7,8,10,11,40};
		Binary_search ob=new Binary_search();
		int target=11;
		int result=ob.Search(arr,0,(arr.length-1),target);
		if(result!=-1) 
			System.out.println("\n ** Target is found at "+result+" ** ");
		else 
			System.out.println("\n ** Target is not found in the list **");
	}
}