//Java DataOutputStream class allows an application to write primitive Java data types to the output stream in a machine-independent way.
import java.io.*;  
public class DataOutputStreamExample
{  
    public static void main(String[] args) throws IOException 
	{  
        FileOutputStream file = new FileOutputStream("C:/Users/AKHIL/Desktop/Java/Programs/Files/DataOutputStream.txt");  
        DataOutputStream data = new DataOutputStream(file);  
        data.writeInt(65);  
        data.flush();  
        data.close();  
        System.out.println("Succcess...");  
    }  
} 