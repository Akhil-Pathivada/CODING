//Method Overloading is not possible by changing the return type of method only
class Adder
{  
	static int add(int a,int b)
	{
		return a+b;
	}  
	static double add(int a,int b)
	{
		return a+b;
	}  
}  
class Method_overload3
{  
	public static void main(String[] args)
	{  
		System.out.println(Adder.add(11,11));//ambiguity  
	}
}
/* 
output : 
		
		error: 
				method add(int,int) is already defined in class Adder
				static double add(int a,int b)
		
		*/