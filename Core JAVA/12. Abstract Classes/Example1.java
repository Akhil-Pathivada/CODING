//Example of Abstract class that has an abstract method
abstract class Bike
{  
      abstract void run();  
}  
class Honda4 extends Bike
{  
    void run()
	{
		System.out.println("running safely");
	}   
} 
class Example1
{
	public static void main(String args[])
	{  
     Bike obj = new Honda4();  
     obj.run();  
    } 
} 
/*
output : 
	running safely
	
	
	*/