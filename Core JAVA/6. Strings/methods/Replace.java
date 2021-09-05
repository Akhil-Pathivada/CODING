//The string replace() method replaces all occurrence of first sequence of character with second sequence of character.
class Replace
{
	public static void main(String args[])
	{
		String s1="Java is a programming language. Java is a platform. Java is an Island.";    
		String s2=s1.replace("Java","Kava");//replaces all occurrences of "Java" with "Kava" 
		System.out.println("\n "+s2);
	}
}
/*
output:		
		 Kava is a programming language. Kava is a platform. Kava is an Island.
*/