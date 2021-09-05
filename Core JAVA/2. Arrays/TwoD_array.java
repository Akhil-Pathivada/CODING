// Printing (1-20 numbers) a 4*5 matrix
class TwoD_array
{
	public static void main(String args[])
	{
		int i,j,k=0;
		int arr[][]=new int[4][5];
		for(i=0;i<4;i++)
		{
			for(j=0;j<5;j++)
			{
				arr[i][j]=k;
				System.out.print(" "+arr[i][j]);
				k++;
			}
			System.out.println();
		}
	}
}