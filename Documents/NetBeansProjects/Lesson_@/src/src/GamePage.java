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

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class GamePage implements  ActionListener{
         



	static JButton homeButton,newMissionButton,playerMangButton,gameConfig;
	static JPanel buttonPanelOne,mapPanel,buttonPanelTwo;
        static JFrame gamePageFrame = new JFrame("Home Page");



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
        mapPanel.setLocation(800, 80);
        mapPanel.setSize(2000, 70);
        totalGUI.add(mapPanel);
        
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

