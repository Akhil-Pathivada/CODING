// Construct one String from another.
class MakeString 
{
public static void main(String args[]) {
char c[] = {'J', 'a', 'v', 'a','x','y','z'};
String s1 = new String(c);
String s=new String(c,2,3);
String s2 = new String(s1);
System.out.println();
System.out.println(s1);
System.out.println(s);
System.out.println(s2);
}
}