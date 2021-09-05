// a simple TextField example
import java.awt.*;  
import java.awt.event.*;
class TextFieldDemo
{  
	TextFieldDemo()
	{
		Frame f= new Frame("TextField Example");  
		TextField t1,t2;  
		t1=new TextField("Welcome to Javatpoint.");  
		t1.setBounds(50,100, 200,30);  
		t2=new TextField("AWT Tutorial");  
		t2.setBounds(50,150, 200,30);  
		f.add(t1); f.add(t2);  
		f.setSize(400,400);  
		f.setLayout(null);  
		f.setVisible(true);  
	}
	public static void main(String args[])
	{  
		new TextFieldDemo();
	}  
}  