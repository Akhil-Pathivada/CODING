class Box
{
	double width;
	double height;
	double depth;
	double Volume()
	{
		return (width*height*depth);
	}
	void setDim(double w,double h,double d)
	{
		width=w;
		depth=d;
		height=h;
	}
}
class Methods_with_parameters
{
	public static void main(String args[])
	{
		Box mybox1=new Box();
		Box mybox2=new Box();
		mybox1.setDim(10,20,15);
		mybox2.setDim(3,6,9);
		double vol=mybox1.Volume();
		System.out.println("\n Volume 1 : "+vol);
		vol=mybox2.Volume();
		System.out.println("\n Volume 2 : "+vol);
	}
}