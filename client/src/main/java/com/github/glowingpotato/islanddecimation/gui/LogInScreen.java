package com.github.glowingpotato.islanddecimation.gui;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class LogInScreen {

	private JLabel label = new JLabel("Login");
	private JTextField usernameTextField = new JTextField();
	private JTextField passwordTextField = new JTextField();
	private JLabel userNameLabel = new JLabel("Username:");
	private JLabel passwordLabel = new JLabel("Password:");
	
	public LogInScreen() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.setTitle("Log In");
		frame.setVisible(true);
		frame.add(panel);
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		userNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		usernameTextField.setColumns(10);
		passwordTextField.setColumns(10);
		panel.add(usernameTextField);
		panel.add(passwordTextField);
		panel.add(userNameLabel);
		panel.add(passwordLabel);
		panel.add(label);
		frame.setSize(500, 250);
		update(panel);
		frame.setSize(501, 250);
		update(panel);
	}
	
	private void update(JPanel panel) {

		SpringLayout springLayout = new SpringLayout();
		panel.setLayout(springLayout);
		
//		springLayout.putConstraint(SpringLayout.NORTH, label, panel.getHeight() / 5, SpringLayout.NORTH, panel);
//		springLayout.putConstraint(SpringLayout.EAST, label, panel.getWidth() / 2, SpringLayout.EAST, panel);
		
		springLayout.putConstraint(SpringLayout.NORTH, usernameTextField, 104, SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, usernameTextField, 182, SpringLayout.WEST, panel);
		
		springLayout.putConstraint(SpringLayout.NORTH, passwordTextField, 21, SpringLayout.SOUTH, usernameTextField);
		springLayout.putConstraint(SpringLayout.EAST, passwordTextField, 0, SpringLayout.EAST, usernameTextField);
		
		springLayout.putConstraint(SpringLayout.NORTH, userNameLabel, 0, SpringLayout.NORTH, usernameTextField);
		springLayout.putConstraint(SpringLayout.EAST, userNameLabel, -45, SpringLayout.WEST, usernameTextField);
		
		springLayout.putConstraint(SpringLayout.NORTH, passwordLabel, 0, SpringLayout.NORTH, passwordTextField);
		springLayout.putConstraint(SpringLayout.EAST, passwordLabel, 0, SpringLayout.EAST, userNameLabel);
	}
	

	private String username = "";
	private String password = "";

	public String getUsername() {
		username = usernameTextField.getText();
		return username;
	}

	public String getPassword() {
		password = passwordTextField.getText();
		return password;
	}
	
	
// 		logIn.addActionListener(new ActionListener() {
// 			public void actionPerformed(ActionEvent action) {
// 				username = usernameField.getText();
// 				password = new String(passwordField.getPassword());
// 				System.out.println(password);
// 				frame.dispose();
// 			}
// 		});
}
