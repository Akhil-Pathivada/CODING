class Matrix_multiplication
{
	static void Multi(int A[][],int B[][],int C[][],int i,int n)
	{
		if(i<n)	
		{
			for(int j=0;j<n;j++)
			{
				C[i][j]=0;
				for(int k=0;k<n;k++)
				{
					C[i][j]+=A[i][k]*B[k][j];
				}
				System.out.print(C[i][j]+" ");  //printing matrix element  
		}
			System.out.println();
			Multi(A,B,C,++i,n);	
		}
	}
	public static void main(String args[])
	{
		int A[][]={{1,2},{3,4}};
		int B[][]={{5,6},{7,8}};
		int C[][]=new int[2][2];
		Multi(A,B,C,0,2);
	}
}