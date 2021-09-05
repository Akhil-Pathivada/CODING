//As we know well that default constructor is provided by compiler automatically if there is no constructor.
// But, it also adds super() as the first statement.
class Animal
{  
	Animal()
	{
		System.out.println("animal is created");
	}  
}  
class Dog extends Animal
{  
	Dog()
	{  
	//super();  
	System.out.println("dog is created");  
	}  
}  
class Super4
{  
	public static void main(String args[])
	{  
		Dog d=new Dog();  
	}
}
/*
output : 
		animal is created
		dog is created
*/