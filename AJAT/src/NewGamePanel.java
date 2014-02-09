import java.awt.ActiveEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class NewGamePanel {
static JFrame frame = new JFrame();
static JLabel title = new JLabel("Creating New Game...");
static JLabel name = new JLabel("Game Name: ");
static JLabel pin = new JLabel("Pin to Join Game: ");
static JLabel numCap = new JLabel("Max Players: ");
static JLabel numTeams = new JLabel("Number of Teams: ");
static JLabel geoFence = new JLabel("Enable Geolocation: ");
static JLabel mission = new JLabel("Enable Missions: ");
static JLabel search = new JLabel("Location of Game:");
static JLabel map = new JLabel();

static JTextField nameF = new JTextField(150);
static JTextField pinF = new JTextField(25);
static JComboBox numCapF = new JComboBox();
static JComboBox numTeamsF = new JComboBox();
static JCheckBox geoFenceF = new JCheckBox();
static JCheckBox missionF = new JCheckBox();
static JButton confirm = new JButton("Confirm");
static JTextField locSearch = new JTextField(150);
static JButton searchB = new JButton("Get Map");
static JButton zoomIn = new JButton("+");
static JButton zoomOut = new JButton("-");
static boolean locOn = false;
static int zoomSet = 15;
static BufferedImage mapImg = null;
static String pinSave = "";
static int maxSave;
static int teamSave;
static boolean missSave=false;
static String mapURL;
static ServerConnector serv;
//static JPanel map = new JPanel("Select Game Range");
public static void createAndShowGUI()
{
	String[] numPlayers = new String[100];
	for(int i = 1; i<=100; i++)
	{
		numPlayers[i-1] = Integer.toString(i*50);
	}
	String[] numTeamsArr = new String[100];
	for(int i =1; i<=100; i++)
	{
		numTeamsArr[i-1] = Integer.toString(i);
	}
	
	numCapF = new JComboBox(numPlayers);
	numTeamsF = new JComboBox(numTeamsArr);
	frame.setLayout(null);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1000,700);
	title.setSize(200,15);
	name.setSize(200,15);
	pin.setSize(200,15);
	numCap.setSize(200,15);
	numTeams.setSize(200,15);
	geoFence.setSize(200,15);
	mission.setSize(200,15);
	search.setSize(200,15);
	
	title.setLocation(175,0);
	title.setSize(200,15);
	name.setLocation(25,100);
	pin.setLocation(25,150);
	numCap.setLocation(25,200);
	numTeams.setLocation(25,250);
	geoFence.setLocation(25,300);
	mission.setLocation(25, 350);
	search.setLocation(25,400);
	
	nameF.setSize(150, 17);
	nameF.setLocation(200,99);
	numCapF.setSize(50,17);
	numCapF.setLocation(200,199);
	numTeamsF.setSize(50,17);
	numTeamsF.setLocation(200,249);
	pinF.setSize(150,17);
	pinF.setLocation(200,149);
	locSearch.setSize(150, 17);
	locSearch.setLocation(200, 399);
	searchB.setSize(100,20);
	searchB.setLocation(355, 397);
	searchB.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			map.setVisible(false);
			frame.add(map);
			frame.validate();
			frame.repaint();
			String url = "http://maps.googleapis.com/maps/api/staticmap?center=";
			String charset = "UTF-8";
			String param1 = locSearch.getText();
			String param2 = "&&zoom="+zoomSet+"&&size=400x600&&sensor=false";
			try{
			mapURL = url+param1+param2;
			URLConnection connection = new URL(mapURL).openConnection();
			connection.setRequestProperty("Accept-Charset",charset);
			InputStream ret = connection.getInputStream();
			BufferedImage img = ImageIO.read(ret);
			mapImg = img;
			map = new JLabel(new ImageIcon(img));
			map.setSize(400,600);
			map.setLocation(550,50);
			frame.add(map);
			frame.validate();
			frame.repaint();
			}
			catch(Exception ex)
			{
				JLabel error = new JLabel("Exception thrown"+ ex.toString());
				error.setSize(700,300);
				error.setLocation(25,300);
				frame.add(error);
				frame.validate();
				frame.repaint();
			}
			
		}
	});
	zoomIn.setSize(50,15);
	zoomOut.setSize(50,15);
	zoomIn.setLocation(200, 430);
	zoomIn.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			zoomSet++;
		}

	});
	zoomOut.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			zoomSet--;
		}

	});
	zoomOut.setLocation(285,430);
	geoFenceF.setSize(20, 15);
	geoFenceF.setLocation(200,299);
	geoFenceF.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			
				
				locSearch.setVisible(!locOn);
				search.setVisible(!locOn);
				searchB.setVisible(!locOn);
				zoomIn.setVisible(!locOn);
				zoomOut.setVisible(!locOn);
				frame.add(zoomIn);
				frame.add(zoomOut);
				frame.add(locSearch);
				frame.add(search);
				frame.add(searchB);
				frame.validate();
				frame.repaint();
				locOn = !locOn;
			
			
		}
	});
	missionF.setSize(20,15);
	missionF.setLocation(200,349);
	missionF.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			missSave=true;
		}
	});
	confirm.setSize(100,30);
	confirm.setLocation(200, 625);
	confirm.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			serv.newGame(name.getText(), pin.getText(),"0", Integer.parseInt((String)numCapF.getSelectedItem()), Integer.parseInt((String)numTeamsF.getSelectedItem()), locOn, missSave, mapURL, mapImg );
			HomePanel hPane = new HomePanel();
			hPane.createAndShowGUI();
			frame.setVisible(false);
		}
	});
	frame.add(title);
	frame.add(name);
	frame.add(pin);
	frame.add(numCap);
	frame.add(numTeams);
	frame.add(geoFence);
	frame.add(mission);
	frame.add(nameF);
	frame.add(pinF);
	frame.add(numCapF);
	frame.add(numTeamsF);
	frame.add(geoFenceF);
	frame.add(missionF);
	frame.add(confirm);
	frame.setVisible(true);
}

public static void main(String[] args)
{
	createAndShowGUI();
}
}
