// as same as 'Example2'
interface Bank
{  
    float rateOfInterest();  
}  
class SBI implements Bank
{  
    public float rateOfInterest()
	{
		return 9.15f;
	}  
}  
class PNB implements Bank
{  
    public float rateOfInterest()
	{
		return 9.7f;
	}  
	//void fun(){System.out.println("fun called ");}
}  
class Example3
{  
    public static void main(String[] args)
	{  
		Bank b = new SBI();  
		System.out.println("ROI: " + b.rateOfInterest());  
		Bank c = new PNB();
		System.out.println("ROI: " + c.rateOfInterest());  
    }
}  
/*

ROI: 9.15
ROI: 9.7

*/