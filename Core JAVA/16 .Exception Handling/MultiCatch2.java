//Rule: All catch blocks must be ordered from most specific to most general i.e. catch for ArithmeticException must come before catch for Exception.
class MultiCatch2
{
	public static void main(String args[])
	{
		try
		{
			int a[]=new int[5];
			a[5]=100/0;
		}
		catch(Exception e) {System.out.println("\n common task completed");} //compile time error
		catch(ArithmeticException e) {System.out.println("\n task 1 compeleted");}
		catch(IndexOutOfBoundsException e) {System.out.println("\n task 2 completed");}
		System.out.println("\n rest of the code ....");
	}
}
/*
compile time error
*/