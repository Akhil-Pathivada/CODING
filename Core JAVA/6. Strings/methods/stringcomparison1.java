class stringcomparison1
{  
     public static void main(String args[])
	 {  
       String s1="Sachin";  
       String s2="Sachin";  
       String s3=new String("Sachin");
       String s4="Saurav";
	   String s5=new String(s4);
       System.out.println(s1.equals(s2));//true  
       System.out.println(s1.equals(s3));//true  
       System.out.println(s1.equals(s4));//false  
	   System.out.println(s4.equals(s5));//true
     }  
}  