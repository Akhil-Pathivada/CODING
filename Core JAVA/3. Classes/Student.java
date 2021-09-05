class Student
{
	int roll;
	float marks;
	Student(int roll,float marks)
	{
		this.roll=roll;
		this.marks=marks;
	}
	void Display()
	{
		System.out.println("Roll_no : "+roll+"  marks : "+marks);
	}
}
class Test
{
	public static void main(String args[])
	{
		Student s1=new Student(12,34f);
		Student s2=new Student(13,35f);
		s1.Display();
		s2.Display();
	}
}