/*
Let's see a PriorityQueue example where we are adding books to queue and printing all the books. 
The elements in PriorityQueue must be of Comparable type. String and Wrapper classes are Comparable by default.
To add user-defined objects in PriorityQueue, you need to implement Comparable interface.
*/

import java.util.*;

class Book implements Comparable<Book>
{
	int id, quantity;
	String name, author, publisher;

	Book(int id, String name, String author, String publisher, int quantity)
	{
		this.id = id;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.quantity = quantity;
	}

	public int compareTo(Book b)
	{
		if(id > b.id)
			return 1;

		if(id < b.id)
			return -1;

		return 0;
	}	
}

class PriorityQueueDemo2
{
	public static void main(String args[])
	{
		Queue<Book> queue = new PriorityQueue<Book>();
		Book b1 = new Book(121,"Let us C","Yashwant Kanetkar","BPB",8);  
    	Book b2 = new Book(233,"Operating System","Galvin","Wiley",6);  
    	Book b3 = new Book(101,"Data Communications & Networking","Forouzan","Mc Graw Hill",4); 

    	// Adding the elements to Queue
    	queue.add(b1);
    	queue.add(b2);
    	queue.add(b3);

    	System.out.println("Traversing the queue elements:");  
    	for(Book b : queue)
    		System.out.println(b.id + " " + b.name + " " + b.author + " " + b.publisher + " " + b.quantity); 

    	queue.remove();

    	System.out.println("After removing one book record:");  
    	for(Book b:queue)  
        	System.out.println(b.id + " " + b.name + " " + b.author + " " + b.publisher + " " + b.quantity); 
  		
	}	
}

/*
Traversing the queue elements:
101 Data Communications & Networking Forouzan Mc Graw Hill 4
233 Operating System Galvin Wiley 6
121 Let us C Yashwant Kanetkar BPB 8

After removing one book record:
121 Let us C Yashwant Kanetkar BPB 8
233 Operating System Galvin Wiley 6
*/