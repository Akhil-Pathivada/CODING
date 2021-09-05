import javax.swing.*;
class ProgressBarExample2 extends JFrame
{
	JProgressBar pb;
	ProgressBarExample2()
	{
		pb=new JProgressBar(0,100);
		pb.setBounds(40,40,160,30);
		pb.setValue(0);
		pb.setStringPainted(true);
		setVisible(true);
		setLayout(null);
		add(pb);
		setSize(400,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		iterate();
	}
	void iterate()
	{
		int i=0;
		while(i<=95)
		{
			pb.setValue(i);
			i+=5;
			try
			{
				Thread.sleep(500);
			}
			catch(Exception e){};
		}
	}
	public static void main(String args[])
	{
		new ProgressBarExample2();
	}
}