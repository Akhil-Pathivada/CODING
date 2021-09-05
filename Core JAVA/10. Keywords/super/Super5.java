//Emp class inherits Person class so all the properties of Person will be inherited to Emp by default.
// To initialize all the property, we are using parent class constructor from child class. 
//In such way, we are reusing the parent class constructor. 
class Person
{
	int id;
	String name;
	float salary;
	Person(int id,String name)
	{
		this.id=id;
		this.name=name;
	}
	void Display()
	{
		System.out.println("\n Id : "+id+"\n Name : "+name+"\n Salary : "+salary);
	}
}
class Emp extends Person
{
	Emp(int id,String name,float salary)
	{
		super(id,name);//reusing 'parent' constructor
		this.salary=salary;
	}
	
}
class Super5
{
	public static void main(String args[])
	{
		Emp ob=new Emp(123,"akhil",11.11f);
		ob.Display();
	}
}
/*
Output : 
		 Id : 123
		Name : akhil
		Salary : 11.11
		*/