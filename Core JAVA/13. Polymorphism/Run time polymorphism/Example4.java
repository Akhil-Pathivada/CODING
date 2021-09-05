//A method is overridden, not the data members, so runtime polymorphism can't be achieved by data members. 
class Bike
{  
     int speedlimit=90;  
}  
class Honda3 extends Bike
{  
     int speedlimit=150;  
}
class Example4
{
     public static void main(String args[])
	 {  
      Bike obj=new Honda3();  
      System.out.println(obj.speedlimit);//90  
	 }  
}
/*
output : 
			90
			
			*/