// creating a Button in a Frame
import java.awt.*;
class ButtonDemo
{
	ButtonDemo()
	{
		Frame f=new Frame("Button Example");
		Button b=new Button("Click me");
		b.setBounds(70,120,70,20);
		f.add(b);
		f.setSize(400,400);
		f.setLayout(null);
		f.setVisible(true);
	}
	public static void main(String args[])
	{
		new ButtonDemo();
	}
}