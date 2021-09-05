//a simple example of AWT where we are creating instance of Frame class(Association)
import java.awt.*;
class AwtDemo2 
{
	AwtDemo2()
	{
		Frame f=new Frame();
		Button b=new Button("Click me");
		b.setBounds(30,50,80,30);
		f.add(b);
		f.setSize(300,300);
		f.setLayout(null);
		f.setVisible(true);
	}
	public static void main(String args[])
	{
		AwtDemo2 ob=new AwtDemo2();
	}
}