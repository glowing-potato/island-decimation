package com.github.glowingpotato.islanddecimation;

import org.lwjgl.glfw.GLFW;

import com.github.glowingpotato.islanddecimation.gui.GLWindow;
import com.github.glowingpotato.islanddecimation.render.IslandRenderer;
import com.github.glowingpotato.islanddecimation.state.GameState;
import com.github.glowingpotato.islanddecimation.util.Perlin;
import com.github.glowingpotato.islanddecimation.world.island.Island;
import com.github.glowingpotato.islanddecimation.world.island.Terrain;

public class Main {
	public static void main(String[] args0) {
		//LogInScreen screen = new LogInScreen();
		//String username = JOptionPane.showInputDialog(null, "Enter your username:");
		//String password = JOptionPane.showInputDialog(null, "Enter your password:");
		GLFW.glfwInit();
		GLWindow window = new GLWindow(800, 600, "Testing", 0);
		window.makeContextCurrent();
		window.init();
		float x = 0;
		float y = 0;
		Perlin p = new Perlin();
		float[] shape = new float[64 * 64];
		for (int i = 0; i < 64 * 64; i++) {
			shape[i] = (float) p.noise(i % 64 / 8d + x, i / 64 / 8d + y, 0) * 3;
		}
		Terrain t = new Terrain(shape);
		GameState.getState().getIslands().add(new Island(0, null, t, null, null));
		window.addRenderer(new IslandRenderer());
		window.loop();
		window.close();
	}
}
