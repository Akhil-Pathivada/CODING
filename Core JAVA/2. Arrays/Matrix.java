class Matrix
{
	public static void main(String args[])
	{
		int i,j,k=0;
		int mat[][]=new int[4][];
		mat[0]=new int[1];
		mat[1]=new int[2];
		mat[2]=new int[3];
		mat[3]=new int[4];
		for(i=0;i<4;i++)
		{
			for(j=0;j<=i;j++)
			{
				mat[i][j]=k++;
				System.out.print(" "+mat[i][j]);
			}
			System.out.println();
		}
	}
}