// Java program to illustrate using return
class Return
{
    public static void main(String args[])
    {
        boolean t = true;
        System.out.println("\n Before the return.");
     
        if (t)
            return;
 
        // Compiler will bypass every statement 
        // after return
        System.out.println("This won't execute.");
    }
}