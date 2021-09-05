
//ArrayDeque storing the objects of a class

import java.util.*;

class Book
{
	int id;
	String name,author,publisher;
	int quantity;
	Book( int id, String name, String author, String publisher, int quantity)
	{
		this.id = id;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.quantity = quantity;
	}
}

class ArrayDequeDemo2
{
	public static void main(String args[])
	{
		Deque<Book> deque = new ArrayDeque<Book>();
		Book b1 = new Book(101,"Let us C","Yashwant Kanetkar","BPB",8);    
		Book b2 = new Book(102,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);    
		Book b3 = new Book(103,"Operating System","Galvin","Wiley",6);    
		
		deque.add(b1);
		deque.add(b2);
		deque.add(b3);
		
		for(Book b : deque)
			System.out.println(" " + b.id + " " + b.name + " " + b.author + " " + b.publisher + " " + b.quantity);
	}
}

/*
 101 Let us C Yashwant Kanetkar BPB 8
 102 Data Communications & Networking Forouzan Mc Graw Hill 4
 103 Operating System Galvin Wiley 6
 */