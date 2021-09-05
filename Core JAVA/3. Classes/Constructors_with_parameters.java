class Box
{
	double width;
	double height;
	double depth;
	double Volume()
	{
		return (width * height * depth);
	}
	Box(double d, double h, double w)	// This is the constructor for Box.
	{
		height = h;
		width = w;
		depth = d;
	}
}
class Constructors_with_parameters
{
	public static void main(String args[])
	{
		Box mybox1 = new Box(10,15,20);
		Box mybox2 = new Box(3,6,9);
		double vol = mybox1.Volume();
		System.out.println("\n Volume 1 : " + vol);
		vol = mybox2.Volume();
		System.out.println("\n Volume 2 : " + vol);
	}
}