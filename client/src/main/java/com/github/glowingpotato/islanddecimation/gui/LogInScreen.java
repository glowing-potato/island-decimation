package com.github.glowingpotato.islanddecimation.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LogInScreen {
	private String username = "";
	private String password = "";

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public LogInScreen() {
		JFrame frame = new JFrame();
		frame.setBounds(0, 0, 500, 500);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		frame.setLayout(null);
		panel.setLayout(null);
		JLabel label = new JLabel("Log In");
		label.setHorizontalAlignment(label.CENTER);
		panel.add(label);
		label.setBounds(0, 0, panel.getWidth(), panel.getHeight() / 4);
		JTextField usernameField = new JTextField();
		panel.add(usernameField);
		usernameField.setBounds(0, (panel.getHeight() / 4) * (1), frame.getWidth(), panel.getHeight() / 4);
		JPasswordField passwordField = new JPasswordField();
		panel.add(passwordField);
		passwordField.setBounds(0, (panel.getHeight() / 4) * (2), panel.getWidth(), panel.getHeight() / 4);
		JButton logIn = new JButton("Log In");
		panel.add(logIn);
		logIn.setBounds(0, (panel.getHeight() / 4) * (3), panel.getWidth(), panel.getHeight() / 4);
		frame.add(panel);
		panel.setVisible(true);
		frame.setVisible(true);
		logIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action) {
				username = usernameField.getText();
				password = new String(passwordField.getPassword());
				System.out.println(password);
				frame.dispose();
			}
		});
	}
}
