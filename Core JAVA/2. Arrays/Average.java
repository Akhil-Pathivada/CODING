class Average
{
	public static void main(String args[])
	{
		double numbers[]={10.2,10.4,10.0,10.3,10.1},average,sum=0;
		int i;
		for(i=0;i<5;i++) sum+=numbers[i];
		average=sum/i;
		System.out.println(" Average : "+average);
	}
}