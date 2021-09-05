//ArrayList consists of 'objects' of a class as elements....

import java.util.*;
class Student
{
	int roll;
	String name;
	float marks;
	Student(int roll,String name,float marks)
	{
		this.roll=roll;
		this.name=name;
		this.marks=marks;
	}
}
class ArrayListDemo2
{
	public static void main(String args[])
	{
		ArrayList<Student> al=new ArrayList<Student>();
		
		// Creating objects for Student class
		Student ob1 = new Student(1,"akhil",23.3f);
		Student ob2 = new Student(2,"mahesh",44f);
		Student ob3 = new Student(3,"ravindra",12.5f);
		
		// Adding objects to the Student List 
		al.add(ob1);
		al.add(ob2);
		al.add(ob3);
		
		// Traversing through Iterator interface 
		Iterator itr = al.iterator();
		
		System.out.println();
		
		while(itr.hasNext())
		{
			Student st=(Student)itr.next();
			System.out.println("Roll : "+st.roll+" Name : "+st.name+" Marks : "+st.marks);
		}
		
		// Traversing through for-each loop
		System.out.println();
		
		for(Student st:al)
			System.out.println("Roll : "+st.roll+" Name : "+st.name+" Marks : "+st.marks);
		
		// Traversing through ListIterator interface (normal order)	
		ListIterator<Student> itr2=al.listIterator();
		System.out.println();
		
		while(itr2.hasNext())
		{
			Student st=(Student)itr2.next();
			System.out.println("Roll : "+st.roll+" Name : "+st.name+" Marks : "+st.marks);
		}
		
		// Traversing through ListIterator interface (reverse order)
		ListIterator<Student> itr3=al.listIterator(al.size());
		System.out.println();
		
		while(itr3.hasPrevious())
		{
			Student st=(Student)itr3.previous();
			System.out.println("Roll : "+st.roll+" Name : "+st.name+" Marks : "+st.marks);
		}
	}
}
