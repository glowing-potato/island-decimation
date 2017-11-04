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
		Perlin p = new Perlin();
		float[] shape = new float[IslandRenderer.ISLAND_SIZE * IslandRenderer.ISLAND_SIZE];
		for (int i = 0; i < shape.length; i++) {
			int x = i % IslandRenderer.ISLAND_SIZE - IslandRenderer.ISLAND_RADIUS;
			int y = i / IslandRenderer.ISLAND_SIZE - IslandRenderer.ISLAND_RADIUS;
			float dist = (float) Math.pow(Math.sqrt(x * x + y * y), 2) / 600f;
			shape[i] = 15f - dist
					- (float) p.noise(i % IslandRenderer.ISLAND_SIZE / 32d, i / IslandRenderer.ISLAND_SIZE / 32d, 0) * 3
							;
		}
		Terrain t = new Terrain(shape);
		GameState.getState().getIslands().add(new Island(0, null, t, null, null));
		window.addUIRenderer(new SkyRenderer());
		window.addGameRenderer(new IslandRenderer());
		window.loop();
		window.close();
	}
}
