class Bubble_sort
{
	public static void main(String args[])
	{
		int arr[]={9,5,4,7,8,2,3,1,6};
		System.out.println("\n The intial array : ");
		for(int i=0;i<arr.length;i++) // Printing Intial Array
		{
			System.out.print("  "+arr[i]);
		}
		for(int i=0;i<arr.length;i++) // 'Bubble sorting' of an Array
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]>arr[j])
				{
					int temp=arr[j];
					arr[j]=arr[i];
					arr[i]=temp;
				}
			}
		}
		System.out.println("\n The sorted array: ");
		for(int i=0;i<arr.length;i++) // Printing Sorted Array
		{
			System.out.print("  "+arr[i]);
		}
		
	}
}