//If you don't use any modifier, it is treated as default bydefault. The default modifier is accessible only within package.


//save by A.java  
package pack;  
class A{  
  void msg(){System.out.println("Hello");}  
}  
//save by B.java  
package mypack;  
import pack.*;  
class B{  
  public static void main(String args[]){  
   A obj = new A();//Compile Time Error  
   obj.msg();//Compile Time Error  
  }  
}  
In the above example, the scope of class A and its method msg() is default so it cannot be accessed from outside the package.
