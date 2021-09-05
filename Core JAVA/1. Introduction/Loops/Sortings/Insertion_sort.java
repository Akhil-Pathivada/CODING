class Insertion_sort
{
	public static void main(String args[])
	{
		int arr[]={9,5,4,7,8,2,3,1,6},key,j;
		System.out.println("\n The intial array : ");
		for(int i=0;i<arr.length;i++) // Printing Intial Array
		{
			System.out.print("  "+arr[i]);
		}
		for(int i=1;i<arr.length;i++) // 'Insertion sorting' of an Array
		{
			key=arr[i];
			for(j=i-1 ;j>=0 && arr[j]>key ;j--)
			{
				arr[j+1]=arr[j];
			}
			arr[j+1]=key;
		}
		System.out.println("\n The sorted array: ");
		for(int i=0;i<arr.length;i++) // Printing Sorted Array
		{
			System.out.print("  "+arr[i]);
		}
		
	}
}