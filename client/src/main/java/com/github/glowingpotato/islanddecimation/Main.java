package com.github.glowingpotato.islanddecimation;

import java.io.File;
import java.util.Arrays;

import javax.swing.JOptionPane;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;

import com.github.glowingpotato.islanddecimation.gui.GLWindow;
import com.github.glowingpotato.islanddecimation.render.GUIRenderer;
import com.github.glowingpotato.islanddecimation.render.IslandRenderer;
import com.github.glowingpotato.islanddecimation.render.SkyRenderer;
import com.github.glowingpotato.islanddecimation.render.TroopRenderer;
import com.github.glowingpotato.islanddecimation.state.GameState;
import com.github.glowingpotato.islanddecimation.util.Perlin;
import com.github.glowingpotato.islanddecimation.view.Island;
import com.github.glowingpotato.islanddecimation.view.Resource;
import com.github.glowingpotato.islanddecimation.view.Terrain;
import com.glutilities.text.FontManager;

public class Main {
	public static void main(String[] args) {
		if (args.length != 2) {
			/*
			 * For debugging, place your email as the first parameter, and your password as
			 * the second parameter in the run configuration for Eclipse (it's under Run
			 * Configurations > Arguments > Program Arguments).
			 */
			JOptionPane.showMessageDialog(null, "Please run this program through the launcher instead of manually.");
			System.exit(1);
		}
		String username = args[0];
		String password = args[1];

		GLFW.glfwInit();
		File f = new File("src/main/resources/models/car.obj");
		GameState.getState().getModelManager().load(f, "test");
		
		GLWindow window = new GLWindow(800, 600, "Testing", 0);
		window.makeContextCurrent();
		window.init();
		GameState.getState().getTextureManager().load(new File("src/main/resources/grass.png"), "test");
		Perlin p = new Perlin();
		Float[] shape = new Float[IslandRenderer.ISLAND_SIZE * IslandRenderer.ISLAND_SIZE];
		for (int i = 0; i < shape.length; i++) {
			int x = i % IslandRenderer.ISLAND_SIZE - IslandRenderer.ISLAND_RADIUS;
			int y = i / IslandRenderer.ISLAND_SIZE - IslandRenderer.ISLAND_RADIUS;
			float dist = (float) Math.pow(Math.sqrt(x * x + y * y), 2) / 1200f;
			shape[i] = 10f - dist
					- (float) p.noise(i % IslandRenderer.ISLAND_SIZE / 64d, i / IslandRenderer.ISLAND_SIZE / 64d, 0)
							* 3;
		}
		Terrain t = new Terrain(Arrays.asList(shape));
		GameState.getState().getIslands().add(new Island(0.0, null, new Resource(1, 2, 3), t, null));
		window.addUIRenderer(new SkyRenderer());
		// window.addUIRenderer(new GUIRenderer());
		window.addGameRenderer(new IslandRenderer());
		window.addGameRenderer(new TroopRenderer());
		window.loop();
		window.close();
	}
}
