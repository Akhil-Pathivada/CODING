// super is used to invoke parent class constructor.
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
		super();   // by default 'super()' be called...
		System.out.println("dog is created");  
	}  
}  
class Super3
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