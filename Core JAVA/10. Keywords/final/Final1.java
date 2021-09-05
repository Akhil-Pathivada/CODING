//If you make any variable as final, you cannot change the value of final variable(It will be constant).
class Final1
{  
     final int speedlimit=90;//final variable  
     void run()
	 {  
      speedlimit=400;  
	 }  
     public static void main(String args[])
	 {  
		Final1 obj=new  Final1();  
		obj.run(); 
		System.out.println("speed limit : "+obj.speedlimit);
     }  
} 
/* 
output :
		compile time error: cannot assign a value to final variable speedlimit
      speedlimit=400;
      ^



*/
		