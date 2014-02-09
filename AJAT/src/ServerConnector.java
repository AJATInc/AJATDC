import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;




public class ServerConnector  {
PrintWriter out;
BufferedReader in;
	public static boolean initConnect()
	{
		try{
		URLConnection connection = new URL("http://localhost:80/post.php?value=65").openConnection();
		connection.setDoOutput(true);
		//connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		connection.setRequestProperty("Accept-Charset", "UTF-8");
		//connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + charset);
		//System.out.println("Hello");
		//OutputStream output = connection.getOutputStream();
		//output.write("hi".getBytes("UTF-8"));
		InputStream response = connection.getInputStream();
		InputStreamReader resr = new InputStreamReader(response);
		BufferedReader br = new BufferedReader(resr);
		System.out.println(br.readLine());
		System.out.println(br.readLine());
		//System.out.println((int)response.read());
		//response.close();
		//InputStream ret = connection.getInputStream();
		//System.out.println(ret.read());
		//System.out.println("Written");
		//InputStream ret = connection.getInputStream();
		//System.out.println(ret.available());
		//ret.close();
		//output.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception: "+e.toString());
		}
		return true;
	}
	public static int confirmCredentials(String uname, String pass) throws IOException
	{
		URLConnection connection = new URL("http://localhost:80/post.php?cmd=login&&u="+uname+"&&p="+pass).openConnection();
		connection.setDoOutput(true);
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		connection.setRequestProperty("Accept-Charset", "UTF-8");
		//connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + charset);
		//System.out.println("Hello");
		InputStream inp = connection.getInputStream();
		InputStreamReader resr = new InputStreamReader(inp);
		BufferedReader br = new BufferedReader(resr);
		System.out.println(br.readLine());
		
		return 0;
	}

public static void newGame(String name, String pin,String adminID, int numP, int numT, boolean geoF, boolean miss, String mapURL,BufferedImage mapImg )
{
	try{
	URLConnection connection = new URL("http://localhost:80/gameAdd?name="+name+"&&pin="+pin+"&&adminID="+adminID+"&&numP="+numP+"&&numT="+numT+"&&geoF="+geoF+"&&miss="+miss+"&&mapURL="+mapURL+"&&mapIm="+mapImg).openConnection();
	connection.setDoOutput(true);
	connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
	connection.setRequestProperty("Accept-Charset", "UTF-8");
	}
	catch (Exception e)
	{
		System.out.println("Exception:" + e.toString());
	}
}
public static void addUserToGame(String user, String userID, String gameName )
{
	try{
		URLConnection connection = new URL("http://localhost:80/update.php?name ="+user+"&&id="+userID+"&&game=,"+gameName).openConnection();
		connection.setDoOutput(true);
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		connection.setRequestProperty("Accept-Charset", "UTF-8");
	}
	catch(Exception e)
	{
		System.out.println("Exception: "+ e.toString());
		
	}
}
public static void newAdmin(String name, String pass)
{
	try{
		URLConnection connection = new URL("http://localhost:80/add.php?name="+name+"&&pass="+pass).openConnection();
		connection.setDoOutput(true);
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		connection.setRequestProperty("Accept-Charset", "UTF-8");
	}
	catch(Exception e)
	{
		System.out.println("Exception: "+ e.toString());
		
	}
}
public static String getUsersFromGame(String game, String id)
{
	try{
		URLConnection connection = new URL("http://localhost:80/select.php?tbl=games&&col=userids&&whr=gameid="+id).openConnection();
		connection.setDoOutput(true);
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		connection.setRequestProperty("Accept-Charset", "UTF-8");
		InputStream inp = connection.getInputStream();
		InputStreamReader resr = new InputStreamReader(inp);
		BufferedReader br = new BufferedReader(resr);
		String output = "";
		String adder = "";
		while((adder+=br.readLine())!=adder)
		{
			output+=adder;
		}
		return output;
	}
	catch(Exception e)
	{
		System.out.println("Exception: "+ e.toString());
		return "Error";
	}
}
public static String getGameFromAdmin(String name, String pass)
{
	try
	{
	URLConnection connection = new URL("http://localhost:80/select.php?tbl=admins&&col=name&&whr=name="+name).openConnection();
	connection.setDoOutput(true);
	connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
	connection.setRequestProperty("Accept-Charset", "UTF-8");
	InputStream inp = connection.getInputStream();
	InputStreamReader resr = new InputStreamReader(inp);
	BufferedReader br = new BufferedReader(resr);
	String output = "";
	String adder = "";
	while((adder+=br.readLine())!=adder)
	{
		output+=adder;
	}
	return output;
	}
	catch(Exception e)
	{
		System.out.println("Exception: "+ e.toString());
		return "Error";
	}
}
public static void removeGame(String name, String id)
{
	try
	{
	URLConnection connection = new URL("https://localhost:80/remove.php?tbl=games&&col=gameid&&whr=gameid="+id).openConnection();
	connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
	connection.setRequestProperty("Accept-Charset", "UTF-8");
	}
	catch(Exception e)
	{
		System.out.println("Exception: "+ e.toString());
		
	}
}
public static void removeUser(String game, String gameid, String user)
{
	try{
	String users = getUsersFromGame(game,gameid);
	if(users.contains(user))
	{
		users.replace(user, "");
	}
	URLConnection connection = new URL("https://localhost:80/update.php?tbl=games&&col=userids&&whr=gameid="+gameid+"&&replace=userids="+users).openConnection();
	}
	catch(Exception e)
	{
		System.out.println("Exception: "+e.toString());
	}
}
public static void main(String[] args) throws IOException
{
	//initConnect();
	
}
}