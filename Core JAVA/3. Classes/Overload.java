// Program for 'Constructor Overloading'
class Box
{
	double length;
	double height;
	double width;
	Box(double l,double h,double w)
	{
		length=l;
		height=h;
		width=w;
	}
	Box() // constructor used when no dimensions specified
	{
		length=width=height=-1; // uses -1 to indicate unintialised Box
	}
	Box(double l) // constructor used when cube is created
	{
		length=width=height=l;
	}
	double Volume()
	{
		return length*height*width;
	}
	
}
class Overload
{
	public static void main(String args[])
	{
		// create boxes using the various constructors
		Box mybox1 = new Box(10, 20, 15);
		Box mybox2 = new Box();
		Box cube = new Box(7);
		double vol;
		vol=mybox1.Volume();
		System.out.println("\n Volume : "+vol);
		vol=mybox2.Volume();
		System.out.println("\n Volume : "+vol);
		vol=cube.Volume();
		System.out.println("\n Volume : "+vol);
	}
}