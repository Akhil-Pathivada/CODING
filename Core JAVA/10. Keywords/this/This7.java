//this: to pass an 'object' as argument in the constructor call
class B
{  
    This7 obj;  
    B(This7 obj)
	{  
        this.obj=obj;  
    }  
    void display()
	{  
        System.out.println(obj.data);//using data member of This7 class  
    }  
}  
      
class This7
{  
    int data=10;  
    This7()
	{  
       B b=new B(this);  
       b.display();  
    } 
    public static void main(String args[])
	{  
       This7 a=new This7();  
    }  
}  
/*
Output:   10
*/