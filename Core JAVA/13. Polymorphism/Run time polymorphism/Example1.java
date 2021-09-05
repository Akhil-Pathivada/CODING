//In this process, an overridden method is called through the reference variable of a superclass. 
//The determination of the method to be called is based on the object being referred to by the reference variable. 
class Bike
{  
  void run()
  {
	  System.out.println("running");
  }  
}  
class Splendor extends Bike
{  
  void run()
  {
	  System.out.println("running safely with 60km");
  }  
} 
class Example1
{ 
	public static void main(String args[])
	{  
		Bike b = new Splendor();//upcasting  
		b.run();  
	}  
}
/*
output : 
		
		running safely with 60km
		
		*/