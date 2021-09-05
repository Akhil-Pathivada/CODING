// simple example of AWT where we are inheriting Frame class(inheritence)
import java.awt.*;
class AwtDemo extends Frame
{
	AwtDemo()
	{
		Button b=new Button("Click me");
		b.setBounds(30,800,80,30);//setting button position
		add(b);//adding button into frame
		setSize(300,300);//frame size 300 width and 300 height
		setLayout(null);//no layout manager
		setVisible(true);//now frame will be visible, by default not visible  
	}
	public static void main(String args[])
	{
		AwtDemo ob=new AwtDemo();
	}
}