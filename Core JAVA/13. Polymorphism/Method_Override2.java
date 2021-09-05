//Java Program to demonstrate the real scenario of Java Method Overriding  
//where three classes are overriding the method of a parent class.   
class Bank
{  
	int getRateOfInterest()
	{
		return 0;
	}  
}   
class SBI extends Bank
{  
	int getRateOfInterest()
	{
		return 8;
	}  
}  
  
class ICICI extends Bank
{  
	int getRateOfInterest()
	{
		return 7;
	}  
}  
class AXIS extends Bank
{  
	int getRateOfInterest()
	{
		return 9;
	}  
}  
class Method_Override2
{  
	public static void main(String args[])
	{  
		SBI s=new SBI();  
		ICICI i=new ICICI();  
		AXIS a=new AXIS();  
		System.out.println("SBI Rate of Interest: "+s.getRateOfInterest());  
		System.out.println("ICICI Rate of Interest: "+i.getRateOfInterest());  
		System.out.println("AXIS Rate of Interest: "+a.getRateOfInterest());  
	}  
} 
/*
	Output:
			SBI Rate of Interest: 8
			ICICI Rate of Interest: 7
			AXIS Rate of Interest: 9
*/