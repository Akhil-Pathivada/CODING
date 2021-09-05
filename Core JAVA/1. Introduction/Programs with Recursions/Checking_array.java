// Checking whether a Array is sorted or not
class Checking_array
{
	static int Check(int arr[],int n)
	{
		if(n==1) return 1;
		
		return (arr[n-1]<arr[n-2])?0:Check(arr,n-1);
	}
	public static void main(String args[])
	{
		int arr[]={1,2,3,4,5,6,8};
		Checking_array ob=new Checking_array();
		int res=ob.Check(arr,arr.length);
		if(res==1) System.out.println("\n ** Array is in Sorted order **");
		else System.out.println("\n ** Array is not in Sorted order ** ");
	}
}