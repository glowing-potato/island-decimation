package com.github.glowingpotato.islanddecimation;

import javax.swing.JOptionPane;
import org.lwjgl.glfw.GLFW;
import com.github.glowingpotato.islanddecimation.gui.GLWindow;

public class Main {
	public static void main(String[] args) {
	    if (args.length != 2) {
            /*
             * For debugging, place your email as the first parameter, and your password as the second parameter in the
             * run configuration for Eclipse (it's under Run Configurations > Arguments > Program Arguments).
             */
	        JOptionPane.showMessageDialog(null, "Please run this program through the launcher instead of manually.");
	        System.exit(1);
	    }
	    String username = args[0];
	    String password = args[1];
		GLFW.glfwInit();
		GLWindow window = new GLWindow(800, 600, "Testing", 0);
		window.makeContextCurrent();
		window.init();
		window.loop();
	}
}
