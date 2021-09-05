// using of 'Object passing' into Constructors
 class Box
{
	double length;
	double height;
	double width;
	Box(double l,double w,double h)
	{
		length=l;
		width=w;
		height=h;
	}
	Box(Box ob) // mybox2 will get same values as of mybox1
	{
		length=ob.length;
		height=ob.height;
		width=ob.width;
	}
	double Volume()
	{
		return length*height*width;
	}
	
}
class ObjectsAsParameters2
{
	public static void main(String args[])
	{
		// create boxes using the various constructors
		Box mybox1 = new Box(10, 20, 15);
		Box mybox2 = new Box(mybox1); // passing an object to constructor
		double vol;
		vol=mybox1.Volume();
		System.out.println("\n Volume : "+vol);
		vol=mybox2.Volume();
		System.out.println("\n Volume : "+vol);
	}
}