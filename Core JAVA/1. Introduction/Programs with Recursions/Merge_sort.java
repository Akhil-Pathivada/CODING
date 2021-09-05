class Merge_sort
{
	static void Merge(int arr[],int l,int m,int r )
	{
		int n1=m-l+1;
		int n2=r-m;
		int i,j,k;
		int temp1[]=new int[n1];
		int temp2[]=new int[n2];
		for(i=0;i<n1;i++) 
			temp1[i]=arr[l+i];
		for(j=0;i<n2;i++) 
			temp2[j]=arr[m+1+j];
		i=0;
		j=0;
		k=l;
		while(i<n1 && j<n2)
		{
			if(temp1[i]<=temp2[j])
			{
				arr[k]=temp1[i];
				i++;
			}
			else 
			{
				arr[k]=temp2[j];
				j++;
			}
			k++;
		}
		// copying the remainining elements 
		while(i<n1)
		{
				arr[k++]=temp1[i];
				i++;
		}
		while(j<n2)
		{
				arr[k++]=temp2[j];
				j++;
		}
	}
	 static void Partition(int arr[],int first,int last)
	{
		if(first<last)
		{
			int mid=(first+last)/2;
			Partition(arr,first,mid);
			Partition(arr,mid+1,last);
			Merge(arr,first,mid,last);
		}
	}
	public static void main(String args[])
    {
        int arr[] = {41, 11, 13, 5, 61, 7};
 
        System.out.println("\n Given Array : ");
		int n = arr.length;
        for (int i=0; i<n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
 
        Merge_sort ob = new Merge_sort();
        ob.Partition(arr,0,n-1);
 
        //System.out.println("\nSorted array");
        System.out.println("\n The sorted array : ");
		for(int i=0;i<n;i++)
		{
			System.out.print("  " +arr[i]);
		}
    }
}