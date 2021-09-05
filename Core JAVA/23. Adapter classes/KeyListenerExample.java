import java.awt.*;
import java.awt.event.*;
class KeyListenerExample extends Frame implements KeyListener
{
	Label l;
	KeyListenerExample()
	{
		l=new Label();
		l.setBounds(20,50,100,20);
		add(l);
		setSize(400,400);
		setVisible(true);
		setLayout(null);
		addKeyListener(this);
	}
	public void keyPressed(KeyEvent e)
	{
		l.setText("Key Pressed.....");
	}
	public void keyReleased(KeyEvent e)
	{
		l.setText("key Released....");
	}
	public void keyTyped(KeyEvent e)
	{
		l.setText("key Typed....");
	}
	public static void main(String args[])
	{
		new KeyListenerExample();
	}
}