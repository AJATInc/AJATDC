import java.net.*;
import java.io.*;
public class EchoServer {
 public static void main(String [] args)
 {
	 int portNumber = 88;
	 
	 try {
		 ServerSocket serverSocket = new ServerSocket(portNumber);
		 Socket clientSocket = serverSocket.accept();
		 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		 
		 String inputLine; 
		 while ((inputLine =in.readLine())!=null)
		 {
			 out.println(inputLine);
		 }
	 }
	 catch(Exception e)
	 {
		 System.out.println("Exception");
	 }
 }
}
