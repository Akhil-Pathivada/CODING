// this: to pass as an argument in the method (or)
// we can send the 'object of the current class' as a parameter
class This6
{  
    void m(This6 obj)
	{  
      System.out.println("method is invoked");  
    }  
    void p()
	{  
		m(this); // (or) this.m(this)
    }  
    public static void main(String args[])
	{  
      This6 s1 = new This6();  
      s1.p();  
    }  
}
/*
Output :
		method is invoked
*/