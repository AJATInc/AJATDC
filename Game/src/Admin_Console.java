 
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class HomePanel implements  ActionListener{
	
	
	JButton homeButton,settingsButton,logoutButton,newGameButton;
	JPanel buttonPanel;

	
	public JPanel createContentPane (){

     
        JPanel totalGUI = new JPanel();
        totalGUI.setLayout(null);

  
      
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setLocation(0, 0);
        buttonPanel.setSize(2000, 70);
        totalGUI.add(buttonPanel);

        
        JButton homeButton= new JButton("Home"); //defines homebutton 
        homeButton.setLocation(0, 0);
        homeButton.setSize(400, 20);
        homeButton.addActionListener(this);
        buttonPanel.add(homeButton);

        JButton newGameButton = new JButton("New Game"); //defines New Game field
        newGameButton.setLocation(400, 0);
        newGameButton.setSize(400,20);
        buttonPanel.add(newGameButton);
        
        JButton settingsButton = new JButton("Settings"); //defines Settings field
        settingsButton.setLocation(800, 0);
        settingsButton.setSize(400,20);
        buttonPanel.add(settingsButton);
        
        JButton logoutButton = new JButton("Logout"); //defines logout field
        logoutButton.setLocation(1200, 0);
        logoutButton.setSize(400,20);
        buttonPanel.add(logoutButton);



        JButton game1Button = new JButton("Game 1"); //defines homebutton 
        game1Button.setLocation(0, 40);
        game1Button.setSize(1600, 30);
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

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("                                                                                                                                                                               Admin Control Panel                                                                                                                                                                                 ");

        //Create and set up the content pane.
        HomePanel demo = new HomePanel();
        frame.setContentPane(demo.createContentPane());
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);  

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 190);
        frame.setVisible(true);
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



