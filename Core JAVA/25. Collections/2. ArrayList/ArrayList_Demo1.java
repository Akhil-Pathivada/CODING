
import java.util.*;   

class ArrayListDemo1
{    
    public static void main(String args[])
    {      
      //creating ArrayList 
      List<String> list1 = new ArrayList<String>(); 
      
      //adding object in arraylist     
      list1.add("Ravi"); 
      list1.add("Vijay");    
      list1.add("Ravi");    
      list1.add("Ajay");    
        
      //creating LinkedList    
      List<String> list2 = new LinkedList<String>();
        
      //adding objects to linkedlist      
      list2.add("James");
      list2.add("Serena");    
      list2.add("Swati");    
      list2.add("Junaid");    
        
      System.out.println(" ArrayList: " + list1);  
      System.out.println(" LinkedList: " + list2);  
    }    
}   

/*
 ArrayList: [Ravi, Vijay, Ravi, Ajay]
 LinkedList: [James, Serena, Swati, Junaid]
*/