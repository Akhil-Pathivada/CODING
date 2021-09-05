import java.awt.event.*;
import java.awt.*;
class MouseMotionListenerExample extends Frame implements MouseMotionListener
{
	MouseMotionListenerExample()
	{
		addMouseMotionListener(this);
		setSize(400,400);
		setLayout(null);
		setVisible(true);
	}
	public void mouseDragged(MouseEvent e)
	{
		Graphics g=getGraphics();
		g.setColor(Color.BLUE);
		 g.fillOval(e.getX(),e.getY(),20,20);  
	}
	public void mouseMoved(MouseEvent e)
	{
		
	}
	public static void main(String args[])
	{
		new MouseMotionListenerExample();
	}
}