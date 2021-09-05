//scrollBar example with AdjustmentListener
import java.awt.*;
import java.awt.event.*;
class ScrollBarExample2
{
	ScrollBarExample2()
	{
		Frame f=new Frame("ScrollBar Example");
		Scrollbar s=new Scrollbar();
		s.setBounds(100,100,50,100);
		f.add(s);
		Label label=new Label();
		label.setSize(400,100);
		f.add(label);
		f.setSize(400,400);
		f.setLayout(null);
		f.setVisible(true);
		s.addAdjustmentListener(new AdjustmentListener()
		{
			public void adjustmentValueChanged(AdjustmentEvent e)
			{
				label.setText("Vertical scrollbar value is : "+s.getValue());
			}
		});
	}
	public static void main(String args[])
	{
		new ScrollBarExample2();
	}
}