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
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class DeskClient {
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
	static JFrame frame = new JFrame("ATAJ Desktop Client");
	static JTextField user = new JTextField(15);
    static JPasswordField pass = new JPasswordField(15);
    static JPanel layout = new JPanel();
    static JLabel emptyLabel = new JLabel("Admin Login");
    static JLabel useLabel = new JLabel("Username: ");
    static JLabel passLabel = new JLabel("Password: ");
    static JButton login = new JButton("Login");
    static JLabel loginCalled = new JLabel(""); 
    private static  void createAndShowGUI() {
        //Create and set up the window.
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
       //layout.setSize(500,300);
        //emptyLabel.setPreferredSize(new Dimension(200, 50));
        emptyLabel.setSize(150,25);
        emptyLabel.setLocation(100,0);
        //emptyLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //emptyLabel.setVerticalAlignment(SwingConstants.TOP);
        useLabel.setSize(100,10);
        useLabel.setLocation(25, 70);
        passLabel.setSize(100,10);
        passLabel.setLocation(25, 140);
        layout.add(emptyLabel);
        //layout.add(useLabel);
       // layout.add(passLabel);
        login.setMnemonic(KeyEvent.VK_ENTER);
        //user.setAlignmentX(SwingConstants.LEFT);
        user.setSize(100,17);
        user.setLocation(125, 68);
        user.requestFocus();
        pass.setEchoChar('*');
        pass.setSize(100,17);
        pass.setLocation(125,138);
        login.setSize(100,17);
        login.setLocation(100,225);
        login.addActionListener(new ActionListener(){
        	public  void actionPerformed(ActionEvent e)
            {
            	Object source = e.getSource();
            	if(source == login)
            	{
            		loginCalled.setText("Attempting Login....");
            		String username = user.getText();
            		char [] password = pass.getPassword();
            		//int ret = server.confirmCredentials(username,password);
            		int ret =200;
            		if(ret == 200)
            		{
            			HomePanel home = new HomePanel();
            			home.createContentPane();
            			frame.setVisible(false);
            			home.createAndShowGUI();
            		}
            	}
            }
        	
        });
    
        frame.getContentPane().add(emptyLabel);
        frame.getContentPane().add(useLabel);
        frame.getContentPane().add(passLabel);
        frame.getContentPane().add(user);
        frame.getContentPane().add(pass);
        frame.getContentPane().add(login);
        //Display the window.
        //frame.pack();
        frame.setVisible(true);
    }
    
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}