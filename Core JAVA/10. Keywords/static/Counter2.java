//Program of counter by static variable
class Counter2
{  
	static int count=0;//will get memory only once and retain its value  
  
	void Counter()
	{  
		count++;//incrementing the value of static variable  
		System.out.println(count);  
	}  
  
	public static void main(String args[])
	{  
		Counter2 c1=new Counter2();  
		Counter2 c2=new Counter2();  
		Counter2 c3=new Counter2(); 
		c1.Counter();
		c2.Counter();
		c3.Counter();
	}  
}  
/*
output :
		1
		2
		3
*/