//In this example, the 'Drawable' interface has only one method. 
//Its implementation is provided by Rectangle and Circle classes. 
interface Drawable
{
	void Draw();
}
class Rectangle implements Drawable
{
	public void Draw()
	{
		System.out.println("Drawing Rectangle");
	}
}
class Circle implements Drawable
{
	public void Draw()
	{
		System.out.println("Drawing Circle");
	}
}
class Example2
{
	public static void main(String args[])
	{
		Drawable ob1,ob2;
		ob1 = new Rectangle();
		ob2 = new Circle();
		ob1.Draw();
		ob2.Draw();
	}
}
/*

Drawing Rectangle
Drawing Circle

*/