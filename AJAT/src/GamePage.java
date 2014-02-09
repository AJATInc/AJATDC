/**
 *
 * @author mccabet
 */

import java.awt.ActiveEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.imageio.ImageIO;
import javax.swing.*;


class GamePage implements  ActionListener{
         



	static JButton homeButton,newMissionButton,playerMangButton,gameConfig;
	static JPanel buttonPanelOne,mapPanel,buttonPanelTwo,spanel;
        
        static JLabel map;
        static JFrame gamePageFrame = new JFrame("Home Page");
        static BufferedImage mapImg = null;
    private static JTextArea textArea;
    static String missX;
    static String missY;
    static ServerConnector serv=new ServerConnector();
    static  JPanel totalGUI = new JPanel();
    static boolean addMission = false;
	public static JPanel createContentPane (){

     
      
        totalGUI.setLayout(null);

  
      
        
        buttonPanelOne = new JPanel();
        buttonPanelOne.setLayout(null);
        buttonPanelOne.setLocation(0, 0);
        buttonPanelOne.setSize(2000, 70);
        totalGUI.add(buttonPanelOne);

       
       // mapPanel  = new JPanel();
       // mapPanel.setLayout(null);
        //mapPanel.setLocation(500, 80);
        //mapPanel.setSize(600,400);
        //totalGUI.add(mapPanel);
        
        
        /*JPanel spanel  = new JPanel();
        JScrollPane userScroll = new JScrollPane( spanel );
        userScroll.setLayout(null);
        userScroll.setLocation(1300, 80);
        userScroll.setSize(250,400);
        totalGUI.add(userScroll);*/
        
        //JLabel userList = new JLabel("Userlist:");
        //userList.setLocation(0, 0);
        //userList.setSize(50, 50);
        //userList.setHorizontalAlignment(0);
        //userScroll.add(userList);
        
          
       


        
        
        
        buttonPanelTwo = new JPanel();
        buttonPanelTwo.setLayout(null);
        buttonPanelTwo.setLocation(100, 500);
        buttonPanelTwo.setSize(500, 500);
        buttonPanelTwo.setOpaque(false);
        totalGUI.add(buttonPanelTwo);
        
        
        

        
        
        homeButton= new JButton("Home"); //Button Defininitions
        homeButton.setLocation(0, 0);
        homeButton.setSize(1200, 20);
        buttonPanelOne.add(homeButton); 
        homeButton.addActionListener(new ActionListener(){
        	public  void actionPerformed(ActionEvent e)
            {
            	Object source = e.getSource();
            	if(source == homeButton)
            	{
                    	HomePanel home = new HomePanel();
            			home.createContentPane();
            			gamePageFrame.setVisible(false);
            			home.createAndShowGUI();
                    
                    
                }
            }
        });
        
        
        
        
        newMissionButton=new JButton("New Mission"); 
        newMissionButton.setLocation(360, 550);
        newMissionButton.setSize(500, 20);
        newMissionButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e)
        	{
        		JLabel desc = new JLabel("Adding Mission...");
        		addMission = !addMission;
        		if(addMission)
        		{
        			
        			desc.setSize(150,20);
        			desc.setLocation(20,75);
        			gamePageFrame.add(desc);
        			gamePageFrame.validate();
        			gamePageFrame.repaint();
        		}
        		else
        		{
        			gamePageFrame.remove(desc);
        			gamePageFrame.validate();
        			gamePageFrame.repaint();
        		}
        	}
        });
        totalGUI.add(newMissionButton);
        
        playerMangButton=new JButton("Player Managment"); 
        playerMangButton.setLocation(360, 590);
        playerMangButton.setSize(500, 20);
        totalGUI.add(playerMangButton);
        
        gameConfig=new JButton("Game Configuration"); 
        gameConfig.setLocation(360, 640);
        gameConfig.setSize(500, 20);
        gameConfig.addActionListener(new ActionListener(){
        	public  void actionPerformed(ActionEvent e)
            {
            	Object source = e.getSource();
           
                    NewGamePanel newgame= new NewGamePanel();
            			
            			gamePageFrame.setVisible(false);
            			newgame.createAndShowGUI();
                    
                    
                }
            });
        
        totalGUI.add(gameConfig);


        String mapURL = "http://maps.googleapis.com/maps/api/staticmap?center=Boston&&size=600x400&&sensor=false";
	String charset = "UTF-8";
        try{
        URLConnection connection = new URL(mapURL).openConnection();
	connection.setRequestProperty("Accept-Charset",charset);
	File ret = new File("/home/john/workspace/AJAT/src/staticmap.png");
	BufferedImage img = ImageIO.read(ret);
	//mapImg = img;
	map = new JLabel(new ImageIcon(img));
	map.setSize(600,400);
	map.setLocation(308,80);
	
	MouseListener mouse = new MouseListener(){
		public void mouseEntered(MouseEvent e)
		{
			
		}
		public void mouseClicked(MouseEvent e)
		{
			if(addMission)
			{
			PointerInfo a = MouseInfo.getPointerInfo();
			Point point = new Point(a.getLocation());
			SwingUtilities.convertPointFromScreen(point, e.getComponent());
			Integer X=(int) point.getX();
			Integer Y=(int) point.getY();
			missX =X.toString();
			missY =Y.toString();
			JLabel xCo = new JLabel("X Coord: "+missX);
			xCo.setSize(100,20);
			xCo.setLocation(20,100);
			
			JLabel yCo = new JLabel("Y Coord: "+missY);
			yCo.setSize(100,20);
			yCo.setLocation(20, 130);
			JButton confMiss = new JButton("Cofirm Mission?");
	        confMiss.setLocation(430,680);
	        confMiss.setSize(300,30);
	        confMiss.setOpaque(true);
	        confMiss.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e)
	        	{
	        		//serv.addMission();
	        		HomePanel home = new HomePanel();
	    			home.createContentPane();
	    			gamePageFrame.setVisible(false);
	    			home.createAndShowGUI();
	    			
	        	}
	        });
	        gamePageFrame.add(confMiss);
	        xCo.setText("X Coord:       ");
	        yCo.setText("Y Coord:       ");
	        gamePageFrame.add(xCo);
	        gamePageFrame.add(yCo);
	        gamePageFrame.validate();
	        gamePageFrame.repaint();
	        xCo.setVisible(false);
	        yCo.setVisible(false);
	        gamePageFrame.validate();
	        gamePageFrame.repaint();
	        xCo.removeAll();
	        yCo.removeAll();
	        xCo.setText("X Coord: "+missX);
	        yCo.setText("Y Coord: "+missY);
	        xCo.setVisible(true);
	        yCo.setVisible(true);
	        gamePageFrame.add(xCo);
	        gamePageFrame.add(yCo);
	        gamePageFrame.validate();
	        gamePageFrame.repaint();
			}
	        File img = new File("/home/john/workspace/AJAT/src/greenmission.png");
	        try{
	        BufferedImage in = ImageIO.read(img);
	        
	        //JLabel mission = new JLabel(new ImageIcon(in));
	        //mission.setLocation(Integer.parseInt(missX),Integer.parseInt(missY));
	        //mission.setOpaque(true);
	        //mission.setSize(40,40);
	        //gamePageFrame.add(mission);
	        //gamePageFrame.validate();
	        //gamePageFrame.repaint();
	        
	        }
	        catch(Exception ex)
	        {
	        	System.out.println(ex.toString());
	        }
	        
	       
		}
		public void mouseExited(MouseEvent e)
		{
			
		}
		public void mouseReleased(MouseEvent e)
		{
			
		}
		public void mousePressed(MouseEvent e)
		{
			
		}
		
	};
	map.addMouseListener(mouse);
		
	
       gamePageFrame.add(map);
       gamePageFrame.validate();
       gamePageFrame.repaint();
        }
            catch(IOException ex)
			{
				JLabel error = new JLabel("Exception thrown"+ ex.toString());
				error.setSize(700,300);
				error.setLocation(25,300);
				gamePageFrame.add(error);
				gamePageFrame.validate();
				gamePageFrame.repaint();
			}
        


        
        totalGUI.setOpaque(true);
        return totalGUI;
    }


	public void actionPerformed(ActionEvent e) {
		
       
       
        }
    




     static void createAndShowGUI() {

        //gamePageFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);  

        //Create and set up the content pane.
        GamePage demo = new GamePage();
        gamePageFrame.setContentPane(demo.createContentPane());
        gamePageFrame.add(map);
        gamePageFrame.validate();
        gamePageFrame.repaint();
        gamePageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gamePageFrame.setSize(1000, 1000);
        gamePageFrame.setVisible(true);
    }


}