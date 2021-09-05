import java.util.*;    
class ArrayListDemo
{    
    public static void main(String args[])
    {      
      //creating arraylist 
      List<String> al = new ArrayList<String>(); 
      
      //adding object in arraylist     
      al.add("Ravi"); 
      al.add("Vijay");    
      al.add("Ravi");    
      al.add("Ajay");    
        
      //creating linkedlist    
      List<String> ll = new LinkedList<String>();
        
      //adding objects to linkedlist      
      ll.add("James");
      ll.add("Serena");    
      ll.add("Swati");    
      ll.add("Junaid");    
        
      System.out.println("ArrayList: " + al);  
      System.out.println("LinkedList: " + ll);  
    }    
}   
 
/*
ArrayList: [Ravi, Vijay, Ravi, Ajay]
LinkedList: [James, Serena, Swati, Junaid]
*/
