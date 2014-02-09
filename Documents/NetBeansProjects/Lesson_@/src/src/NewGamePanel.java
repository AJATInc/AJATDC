/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package src;    

/**
 *
 * @author mccabet
 */

import java.awt.ActiveEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
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



	public static JPanel createContentPane (){

     
        JPanel totalGUI = new JPanel();
        totalGUI.setLayout(null);

  
      
        
        buttonPanelOne = new JPanel();
        buttonPanelOne.setLayout(null);
        buttonPanelOne.setLocation(0, 0);
        buttonPanelOne.setSize(2000, 70);
        totalGUI.add(buttonPanelOne);

       
        mapPanel  = new JPanel();
        mapPanel.setLayout(null);
        mapPanel.setLocation(500, 80);
        mapPanel.setSize(600,400);
        totalGUI.add(mapPanel);
        
        
        JPanel spanel  = new JPanel();
        JScrollPane userScroll = new JScrollPane( spanel );
        userScroll.setLayout(null);
        userScroll.setLocation(1300, 80);
        userScroll.setSize(250,400);
        totalGUI.add(userScroll);
        
        JLabel userList = new JLabel("Userlist:");
        userList.setLocation(0, 0);
        userList.setSize(50, 50);
        userList.setHorizontalAlignment(0);
        userScroll.add(userList);
        
          
       


        
        
        
        buttonPanelTwo = new JPanel();
        buttonPanelTwo.setLayout(null);
        buttonPanelTwo.setLocation(0, 700);
        buttonPanelTwo.setSize(2000, 500);
        totalGUI.add(buttonPanelTwo);
        
        
        

        
        
        homeButton= new JButton("Home"); //Button Defininitions
        homeButton.setLocation(0, 0);
        homeButton.setSize(1600, 20);
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
        newMissionButton.setLocation(400, 0);
        newMissionButton.setSize(800, 20);
        buttonPanelTwo.add(newMissionButton);
        
        playerMangButton=new JButton("Player Managment"); 
        playerMangButton.setLocation(400, 40);
        playerMangButton.setSize(800, 20);
        buttonPanelTwo.add(playerMangButton);
        
        gameConfig=new JButton("Game Configuration"); 
        gameConfig.setLocation(400, 80);
        gameConfig.setSize(800, 20);
        buttonPanelTwo.add(gameConfig);

       

        String mapURL = "http://maps.googleapis.com/maps/api/staticmap?center=Boston&&size=600x400&&sensor=false";
	String charset = "UTF-8";
        try{
        URLConnection connection = new URL(mapURL).openConnection();
	connection.setRequestProperty("Accept-Charset",charset);
	InputStream ret = connection.getInputStream();
	BufferedImage img = ImageIO.read(ret);
	mapImg = img;
	map = new JLabel(new ImageIcon(img));
	map.setSize(600,400);
	map.setLocation(0,0);
        mapPanel.add(map);
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

        gamePageFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);  

        //Create and set up the content pane.
        GamePage demo = new GamePage();
        gamePageFrame.setContentPane(demo.createContentPane());

        gamePageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gamePageFrame.setSize(1600, 1600);
        gamePageFrame.setVisible(true);
    }


}


/**
 *
 * @author mccabet
 */

