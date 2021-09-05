//The = = operator compares references but not values.
class stringcomparison3
{  
	public static void main(String args[])
	{  
		String s1="Sachin";  
		String s2="Sachin";  
		String s3=new String("Sachin");
		String s4=new String(s2);
		System.out.println(s1==s2);//true (because both refer to same instance)  
		System.out.println(s1==s3);//false(because s3 refers to instance created in nonpool)
		System.out.println(s2==s4);//false
		System.out.println(s1==s4);//false
	}  
}