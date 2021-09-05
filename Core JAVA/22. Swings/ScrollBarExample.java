import javax.swing.*;
import java.awt.event.*;
class ScrollBarExample
{
	ScrollBarExample()
	{
		JFrame f=new JFrame("ScrollBar Example");
		JLabel label=new JLabel();
		f.setSize(400,400);
		f.setLayout(null);
		f.setVisible(true);
		f.add(label);
		JScrollBar sb = new JScrollBar();
		f.add(sb);
		sb.setBounds(100,100,50,100);
		label.setSize(400,100);
		sb.addAdjustmentListener(new AdjustmentListener()
		{
			public void adjustmentValueChanged(AdjustmentEvent e)
			{
				label.setText("Vertical ScrollBar value : "+e.getValue());
			}
		});
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String args[])
	{
		new ScrollBarExample();
	}
}