/*
 Traversing an ArrayList which contains 'objects of a class' as elements.
 Traversing through 'ListIterator' interface
 can be starts from any given position
*/
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

class ListIteratorDemo2
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

		ListIterator<Student> itr = al.listIterator();
		
		while(itr.hasNext())
		{
			Student st = (Student)itr.next();
			System.out.println(" Roll : " + st.roll + " Name : " + st.name + " Marks : " + st.marks);
		}
		
		ListIterator<Student> itr2 = al.listIterator(1); //starts from index-1 onwards
		while(itr2.hasNext())
		{
			Student st=(Student)itr2.next();
			System.out.println(" Roll : " + st.roll + " Name : " + st.name + " Marks : " + st.marks);
		}
	}
}
/*
 Roll : 1 Name : akhil Marks : 23.3
 Roll : 2 Name : mahesh Marks : 44.0
 Roll : 3 Name : ravindra Marks : 12.5
 
 Roll : 2 Name : mahesh Marks : 44.0
 Roll : 3 Name : ravindra Marks : 12.5

*/