// another example of inner class
class Outer 
{ 
   // Simple nested inner class 
   class Inner 
   { 
      public void show() 
	  { 
           System.out.println("In a nested class method"); 
      } 
   } 
} 
class InnerClassDemo4
{ 
   public static void main(String[] args) 
   { 
       Outer.Inner in = new Outer().new Inner();  // creating object to Inner class
       in.show();
   } 
} 

/*
In a nested class method
*/