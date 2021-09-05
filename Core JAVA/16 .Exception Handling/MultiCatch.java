class MultiCatch
{
	public static void main(String args[])
	{
		try
		{
			int a[]=new int[5];
			a[5]=100;
		}
		catch(ArithmeticException e) {System.out.println("\n task 1 compeleted");}
		catch(IndexOutOfBoundsException e) {System.out.println("\n task 2 completed");}
		catch(Exception e) {System.out.println("\n common task completed");}
	
		
		System.out.println("\n rest of the code ....");
	}
}
/*

 task 2 compeleted

 rest of the code ....
 
 */