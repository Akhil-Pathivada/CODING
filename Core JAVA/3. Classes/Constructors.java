class Box
{
	double width;
	double height;
	double depth;
	double Volume()
	{
		return (width*height*depth);
	}
	Box()	// This is the constructor for Box.
	{
		height=10;
		width=10;
		depth=10;
	}
}
class Constructors
{
	public static void main(String args[])
	{
		Box mybox1=new Box();
		Box mybox2=new Box();
		double vol=mybox1.Volume();
		System.out.println("\n Volume 1 : "+vol);
		vol=mybox2.Volume();
		System.out.println("\n Volume 2 : "+vol);
	}
}