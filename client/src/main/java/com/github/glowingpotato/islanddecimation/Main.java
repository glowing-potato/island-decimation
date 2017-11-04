package com.github.glowingpotato.islanddecimation;

import org.lwjgl.glfw.GLFW;

import com.github.glowingpotato.islanddecimation.gui.GLWindow;
import com.github.glowingpotato.islanddecimation.gui.LogInScreen;

public class Main {
	public static void main(String[] args0) {
		LogInScreen screen = new LogInScreen();
		//String username = JOptionPane.showInputDialog(null, "Enter your username:");
		//String password = JOptionPane.showInputDialog(null, "Enter your password:");
		GLFW.glfwInit();
		GLWindow window = new GLWindow(800, 600, "Testing", 0);
		window.makeContextCurrent();
		window.init();
		window.loop();
	}
}
