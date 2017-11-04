package com.github.glowingpotato.islanddecimation.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class LogInScreen {

	private JLabel label = new JLabel("Login");
	private JTextField usernameTextField = new JTextField();
	private JPasswordField passwordTextField = new JPasswordField();
	private JLabel userNameLabel = new JLabel("Username:");
	private JLabel passwordLabel = new JLabel("Password:");
	private JButton logInButton = new JButton("Log In");
	
	private int frameWidth = 300;
	private int frameHeight = 200;
	
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
		panel.add(logInButton);
		panel.add(label);
		frame.setSize(frameWidth, frameHeight);
		update(panel);
//		frame.setSize(501, 250);
//		update(panel);
 		logInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action) {
				username = usernameTextField.getText();
				password = new String(passwordTextField.getPassword());
				System.out.println(password);
				frame.dispose();
			}
		});
	}
	
	private void update(JPanel panel) {

		SpringLayout springLayout = new SpringLayout();
		panel.setLayout(springLayout);
		
		springLayout.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, label, frameWidth / 2, SpringLayout.WEST, panel);
		
		springLayout.putConstraint(SpringLayout.NORTH, usernameTextField, frameHeight / 3, SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.EAST, usernameTextField, -10, SpringLayout.EAST, panel);
		
		springLayout.putConstraint(SpringLayout.NORTH, passwordTextField, 10, SpringLayout.SOUTH, usernameTextField);
		springLayout.putConstraint(SpringLayout.EAST, passwordTextField, 0, SpringLayout.EAST, usernameTextField);
		
		springLayout.putConstraint(SpringLayout.NORTH, userNameLabel, 0, SpringLayout.NORTH, usernameTextField);
		springLayout.putConstraint(SpringLayout.EAST, userNameLabel, -45, SpringLayout.WEST, usernameTextField);

		springLayout.putConstraint(SpringLayout.NORTH, passwordLabel, 0, SpringLayout.NORTH, passwordTextField);
		springLayout.putConstraint(SpringLayout.EAST, passwordLabel, 0, SpringLayout.EAST, userNameLabel);
		
		springLayout.putConstraint(SpringLayout.SOUTH, logInButton, 0, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.EAST, logInButton, 0, SpringLayout.EAST, panel);
	}
	

	private String username = "";
	private String password = "";

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}
