import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ServerConnector  {
PrintWriter out;
BufferedReader in;
	public boolean initConnect()
	{
		String hostname = "localhost";
		int port = 80;
		
		try{
			Socket serverSocket = new Socket(hostname,port);
			out = new PrintWriter(serverSocket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	public int confirmCredentials(String uname, String pass) throws IOException
	{
		String jsonOut = "{\n\t\"uname\" : \""+ uname +"\",\n\t\"pass\" : \""+pass+"\"\n}";
		out.print(jsonOut);
		String ret1 = in.readLine();
		int ret = Integer.parseInt(ret1);
		
		
		return ret;
	}
}
