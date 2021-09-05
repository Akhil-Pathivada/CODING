// linked list can holds 'objects' of a class
import java.util.*;
class Book
{
	int id;
	String name,author,publisher;
	int quantity;
	public Book(int id,String name,String author,String publisher,int quantity)
	{
		this.id = id;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.quantity = quantity;
	}
}
class LinkedListDemo2
{
	public static void main(String args[])
	{
		// creating a list of books
		LinkedList<Book> LL = new LinkedList<Book>();
		//creating books
		Book b1 = new Book(101,"Let us C","Yashwant Kanetkar","BPB",8);  
		Book b2 = new Book(102,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);  
		Book b3 = new Book(103,"Operating System","Galvin","Wiley",6); 
		
		//Adding books to the list
		LL.add(b1);
		LL.add(b2);
		LL.add(b3);
		
		// Traversing the list
		for(Book b : LL)
			System.out.println(b.id + " " + b.name + " " + b.author + " " + b.publisher + " " + b.quantity);
	}
}
/*
101 Let us C Yashwant Kanetkar BPB 8
102 Data Communications & Networking Forouzan Mc Graw Hill 4
103 Operating System Galvin Wiley 6
*/