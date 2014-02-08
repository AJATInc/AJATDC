

package src;

/**
 *
 * @author mccabet
 */

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class HomePanel implements  ActionListener{


	static JButton homeButton,settingsButton,logoutButton,newGameButton,game1Button;
	static JPanel buttonPanel;
        
        static JFrame homeFrame = new JFrame("Home Page");


	public JPanel createContentPane (){

     
        final JPanel totalGUI = new JPanel();
        totalGUI.setLayout(null);

  
      
        
        buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setLocation(0, 0);
        buttonPanel.setSize(2000, 1000);
        totalGUI.add(buttonPanel);
        
        JLabel gameLabel = new JLabel("Active Games:");
        gameLabel.setLocation(750, 40);
        gameLabel.setSize(100, 30);
        gameLabel.setHorizontalAlignment(0);
        buttonPanel.add(gameLabel);

        
        homeButton= new JButton("Home"); //defines homebutton 
        homeButton.setLocation(0, 0);
        homeButton.setSize(400, 20);
        homeButton.addActionListener(this);
        buttonPanel.add(homeButton);

        newGameButton = new JButton("New Game"); //defines New Game field
        newGameButton.setLocation(400, 0);
        newGameButton.setSize(400,20);
        buttonPanel.add(newGameButton);
         newGameButton.addActionListener(new ActionListener(){
        	public  void actionPerformed(ActionEvent e)
            {
            	Object source = e.getSource();
            	if(source == newGameButton)
            	{
                    NewGamePanel newgame= new NewGamePanel();
            			
            			homeFrame.setVisible(false);
            			newgame.createAndShowGUI();
                    
                    
                }
            }
        });
        
        
        
        
        
        
        settingsButton = new JButton("Settings"); //defines Settings field
        settingsButton.setLocation(800, 0);
        settingsButton.setSize(400,20);
        buttonPanel.add(settingsButton);
        
        logoutButton = new JButton("Logout"); //defines logout field
        logoutButton.setLocation(1200, 0);
        logoutButton.setSize(400,20);
        logoutButton.addActionListener(new ActionListener(){
        	public  void actionPerformed(ActionEvent e)
            {
            	Object source = e.getSource();
            	if(source == logoutButton)
            	{
                    
                 int result = JOptionPane.showConfirmDialog(
            homeFrame,
            "Are you sure you want to exit the application?",
            "Exit Application",
            JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION)
            System.exit(0); 
            
                }
            }
        }
        );
        buttonPanel.add(logoutButton);



        game1Button = new JButton("Game 1"); //defines homebutton 
        game1Button.setLocation(0, 70);
        game1Button.setSize(1600, 30);
        game1Button.addActionListener(new ActionListener(){
        	public  void actionPerformed(ActionEvent e)
            {
            	Object source = e.getSource();
            	if(source == game1Button)
            	{
                    
                    GamePage gamep = new GamePage();
            		gamep.createContentPane();
            		homeFrame.setVisible(false);
                        homeFrame.toBack();
            		gamep.createAndShowGUI();
                    
                    
                }
            }
        }
        );
        buttonPanel.add(game1Button); 
        
        totalGUI.setOpaque(true);
        return totalGUI;
    }


        
        
        
        
	public void actionPerformed(ActionEvent e) {
            
		if(e.getSource() == homeButton){
			//Insert Button Action Here
		}
		if(e.getSource() == newGameButton){
			//Insert Button Action Here
		}
       
		if(e.getSource() == settingsButton){
		//Insert Button Action Here
		}
       
		if(e.getSource() == logoutButton){
			//Insert Button Action Here
		}
             
                
       
        }
    

     static void createAndShowGUI() {

      //  JFrame.setDefaultLookAndFeelDecorated(true);
        //JFrame frame = new JFrame("                                                                                                                                                                               Admin Control Panel                                                                                                                                                                                 ");
        homeFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);  

        //Create and set up the content pane.
        HomePanel demo = new HomePanel();
        homeFrame.setContentPane(demo.createContentPane());

        homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeFrame.setSize(1600, 1600);
        homeFrame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    } 
}

