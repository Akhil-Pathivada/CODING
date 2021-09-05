// JProgrssBar is used to display the Progress of the task....
import javax.swing.*;
class ProgressBarExample extends JFrame
{
	JProgressBar pb;
	int i=0;
	ProgressBarExample()
	{
		pb=new JProgressBar(0,100); // min,max values
		pb.setBounds(40,40,160,30);
		pb.setValue(55);
		pb.setStringPainted(true);
		add(pb);
		setLayout(null);
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String args[])
	{
		ProgressBarExample obj=new ProgressBarExample();
	}
}