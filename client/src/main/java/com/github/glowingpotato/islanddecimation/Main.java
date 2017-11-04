package com.github.glowingpotato.islanddecimation;

import org.lwjgl.glfw.GLFW;

import com.github.glowingpotato.islanddecimation.gui.GLWindow;
import com.github.glowingpotato.islanddecimation.render.IslandRenderer;
import com.github.glowingpotato.islanddecimation.render.SkyRenderer;
import com.github.glowingpotato.islanddecimation.state.GameState;
import com.github.glowingpotato.islanddecimation.util.Perlin;
import com.github.glowingpotato.islanddecimation.world.island.Island;
import com.github.glowingpotato.islanddecimation.world.island.Terrain;

public class Main {
	public static void main(String[] args0) {
		// LogInScreen screen = new LogInScreen();
		// String username = JOptionPane.showInputDialog(null, "Enter your username:");
		// String password = JOptionPane.showInputDialog(null, "Enter your password:");
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
