import java.awt.*;
import java.awt.event.*;
class MouseListenerExample extends Frame implements MouseListener 
{
	Label l;
	MouseListenerExample()
	{
		l=new Label();
		l.setBounds(20,50,100,20);
		add(l);
		setSize(400,400);
		setLayout(null);
		setVisible(true);
		addMouseListener(this);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void mouseClicked(MouseEvent e)
	{
		l.setText("Mouse Clicked....");
	}
	public void mouseEntered(MouseEvent e)
	{
		l.setText("Mouse entered....");
	}
	public void mouseExited(MouseEvent e)
	{
		l.setText("Mouse exited....");
	}
	public void mousePressed(MouseEvent e)
	{
		l.setText("Mouse pressed....");
	}
	public void mouseReleased(MouseEvent e)
	{
		l.setText("Mouse released....");
	}
	public static void main(String args[])
	{
		new MouseListenerExample();
	}
}