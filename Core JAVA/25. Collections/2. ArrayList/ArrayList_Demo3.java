// Adding elements into 'ArrayList' at different positions

import java.util.*;

class Student
{
	int roll;
	String name;
	float marks;
	Student(int roll,String name,float marks)
	{
		this.roll = roll;
		this.name = name;
		this.marks = marks;
	}
}

class ArrayListDemo3
{
	public static void main(String args[])
	{
		ArrayList<Student> al = new ArrayList<Student>();
		Student ob1 = new Student(1,"akhil",23.3f);
		Student ob2 = new Student(2,"mahesh",44f);
		Student ob3 = new Student(3,"ravindra",12.5f);

		al.add(ob1);
		al.add(ob2);
		al.add(ob3);
		
		// printing the entire list
		
		System.out.println("Initial List : ");
		for(Student st : al)
		{
			System.out.println(" Roll : " + st.roll + " Name : " + st.name + " Marks : " + st.marks);
		}
		
		// Random Accessing
		System.out.println("Data at second position : ");
		System.out.println(" Roll : "+al.get(2).roll+" Name : "+ al.get(2).name+" Marks : "+ al.get(2).marks);
		
		//Adding new element at 2nd position
		Student ob4 = new Student(4,"Bhargavi",22f);
		al.add(2,ob4);

		System.out.println("After adding other object at second position :");
		for(Student st : al)
		{
			System.out.println(" Roll : "+ st.roll + " Name : " + st.name + " Marks : " + st.marks);
		}
		
		//Adding new elements 
		ArrayList<Student> al2 = new ArrayList<Student>();
		Student ob5 = new Student(5,"Dinesh",42f);
		Student ob6 = new Student(6,"Saranya",56f);
		al2.add(ob5);
		al2.add(ob6);
		al.addAll(1,al2); // al.addAll(al2) :  will adds at the ends of the list

		System.out.println("After adding new elements from 1st position onwards");
		for(Student st : al)
		{
			System.out.println(" Roll : "+st.roll+" Name : "+st.name+" Marks : "+st.marks);
		}
	}
}
/*
Initial List : 
 Roll : 1 Name : akhil Marks : 23.3
 Roll : 2 Name : mahesh Marks : 44.0
 Roll : 3 Name : ravindra Marks : 12.5
Data at second position : 
 Roll : 3 Name : ravindra Marks : 12.5
After adding other object at second position :
 Roll : 1 Name : akhil Marks : 23.3
 Roll : 2 Name : mahesh Marks : 44.0
 Roll : 4 Name : Bhargavi Marks : 22.0
 Roll : 3 Name : ravindra Marks : 12.5
After adding new elements from 1st position onwards
 Roll : 1 Name : akhil Marks : 23.3
 Roll : 5 Name : Dinesh Marks : 42.0
 Roll : 6 Name : Saranya Marks : 56.0
 Roll : 2 Name : mahesh Marks : 44.0
 Roll : 4 Name : Bhargavi Marks : 22.0
 Roll : 3 Name : ravindra Marks : 12.5

*/