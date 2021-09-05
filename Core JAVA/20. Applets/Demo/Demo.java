import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.applet.*;
public class Demo extends JFrame
{
	Demo()
	{
		add(new MyCanvas());
		setSize(500,500);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String args[])
	{
		new Demo();
	}
}
class MyCanvas extends Canvas implements Runnable
{
	boolean stopFlag;
	Thread t=null;
	String msg="this is something";
	public MyCanvas()
	{
		setSize(300,300);
		setBackground(Color.GREEN);
	}
	/*public void init()
	{
		setSize(300,300);
		setBackground(Color.GREEN);
	}*/
	public void start() 
	{
		t = new Thread(this);
		stopFlag = false;
		t.start();
	}
	public void run()
	{
		// Redisplay banner
		for( ; ; ) 
		{
			try 
			{
				repaint();
				Thread.sleep(1);
				//if(stopFlag)
						//break;
			} 
			catch(InterruptedException e) {}
		}
	}
	public void stop()
	{
		stopFlag=true;
		t=null;
	}
	public void paint(Graphics g)
	{
		char ch;
		ch = msg.charAt(0);
		msg = msg.substring(1, msg.length());
		msg += ch;
		g.drawString(msg, 50, 30);
	}
}