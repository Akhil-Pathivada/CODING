// Removing elements from ArrayList

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
class ArrayListDemo4
{
	public static void main(String args[])
	{
		ArrayList<Student> al = new ArrayList<Student>();
		Student ob1 = new Student(1,"Akhil",23.3f);
		Student ob2 = new Student(2,"Mahesh",44f);
		Student ob3 = new Student(3,"Ravindra",12.5f);
		
		al.add(ob1);
		al.add(ob2);
		al.add(ob3);
		
		// printing the entire list
		System.out.println("Initial List : ");
		for(Student st : al)
		{
			System.out.println(" Roll : " + st.roll + " Name : " + st.name + " Marks : " + st.marks);
		}
		
		// Removing a specific element by reference
		al.remove(ob2);
		System.out.println(" After removing obj-2 : ");
		for(Student st : al)
		{
			System.out.println(" Roll : " + st.roll + " Name : " + st.name + " Marks : " + st.marks);
		}
		
		// Removing a specific element by index
		al.remove(0); 
		System.out.println(" After removing element at index-0 : ");
		for(Student st : al)
		{
			System.out.println(" Roll : "+st.roll+" Name : "+st.name+" Marks : "+st.marks);
		}
		
		// Adding a new list
		ArrayList<Student> al2 = new ArrayList<Student>();
		Student ob4 = new Student(4,"Sachin",14f);
		Student ob5 = new Student(5,"Virat",53f);
		al2.add(ob4);
		al2.add(ob5);
		al.addAll(al2);
		System.out.println(" After adding new list :");
		for(Student st : al)
		{
			System.out.println(" Roll : " + st.roll + " Name : " + st.name + " Marks : " + st.marks);
		}
		
		//removing new list
		//al.removeFirst(); //Compile Error
		al.removeAll(al2);
		System.out.println(" After removing new list :");
		for(Student st : al)
		{
			System.out.println(" Roll : "+st.roll+" Name : "+st.name+" Marks : "+st.marks);
		}
		
		//al.clear(); //clears the entire list
		
	}
}

/*
Initial List : 
 Roll : 1 Name : Akhil Marks : 23.3
 Roll : 2 Name : Mahesh Marks : 44.0
 Roll : 3 Name : Ravindra Marks : 12.5
 After removing obj-2 : 
 Roll : 1 Name : Akhil Marks : 23.3
 Roll : 3 Name : Ravindra Marks : 12.5
 After removing element at index-0 : 
 Roll : 3 Name : Ravindra Marks : 12.5
 After adding new list :
 Roll : 3 Name : Ravindra Marks : 12.5
 Roll : 4 Name : Sachin Marks : 14.0
 Roll : 5 Name : Virat Marks : 53.0
 After removing new list :
 Roll : 3 Name : Ravindra Marks : 12.5
*/