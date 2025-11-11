import java.io.*;
import java.net.*;

class ChatServer
{
    public static void main(String A[]) throws Exception
    {
        ServerSocket ssobj = new ServerSocket(5100);
        System.out.println("Server is waiting at port 5100");

        Socket sobj = ssobj.accept();
        System.out.println("Client Request gets accepted successfully");

        PrintStream pobj = new PrintStream(sobj.getOutputStream());
        BufferedReader bobj1 = new BufferedReader(new InputStreamReader(sobj.getInputStream()));
        BufferedReader bobj2 = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("---------------------------------------------------");
        System.out.println("-----------------Marvellous Server-----------------");
        System.out.println("---------------------------------------------------");

        String str1 = null, str2 = null;

        while((str1 = bobj1.readLine()) != null)
        {   
            System.out.println("Client says : "+str1);
            System.out.println("Enter msg for client : ");
            str2 = bobj2.readLine();
            pobj.println(str2);
        }     
    }   
}