class Vehicle
{
	void run()
	{
		System.out.println(" Vehicle is running....");
	}
}
class Bike extends Vehicle
{
	void run()
	{
		System.out.println(" Bike is running....");
		//super.run();    // calls 'run' method in Vehicle(super) class
	}
}
class Method_Override1
{
	public static void main(String args[])
	{
		Bike ob=new Bike();
		ob.run();
	}
}
/* 
output :
		Bike is running....
		
*/