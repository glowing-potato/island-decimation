package com.github.glowingpotato.islanddecimation.gui;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

import com.github.glowingpotato.islanddecimation.render.Camera;
import com.github.glowingpotato.islanddecimation.render.Renderer;
import com.github.glowingpotato.islanddecimation.state.GameState;
import com.glutilities.util.GLMath;

public class GLWindow {

	private long window;
	private List<Renderer> gameRenderers = new ArrayList<Renderer>();
	private List<Renderer> UIRenderers = new ArrayList<Renderer>();
	
	public GLWindow(int width, int height, String title, long monitor) {
		window = GLFW.glfwCreateWindow(width, height, title, monitor, 0);
		GLFW.glfwShowWindow(window);
	}
	
	public void makeContextCurrent() {
		GLFW.glfwMakeContextCurrent(window);
	}
	
	public void init() {
		GL.createCapabilities();

		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthFunc(GL11.GL_LEQUAL);
		GL11.glHint(GL11.GL_PERSPECTIVE_CORRECTION_HINT, GL11.GL_NICEST);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		//GL20.glBlendEquationSeparate(GL20.GL_BL, modeAlpha);
		GL11.glMaterialfv(GL11.GL_FRONT, GL11.GL_SPECULAR, new float[] { 0.3f, 0.3f, 0.3f, 1 });
		GL11.glMaterialfv(GL11.GL_FRONT, GL11.GL_SHININESS, new float[] { 10, 0, 0, 0 });
		GL11.glLightfv(GL11.GL_LIGHT0, GL11.GL_POSITION, new float[] { 15, 15, 15, 0 });
		GL11.glColorMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE);
		GL11.glShadeModel(GL11.GL_SMOOTH);

		GL11.glClearColor(0, 0, 0, 1);
	}
	
	public void loop() {
		while (!GLFW.glfwWindowShouldClose(window)) {
			int[] width = new int[1], height = new int[1];
			GLFW.glfwGetWindowSize(window, width, height);
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			GL11.glViewport(0, 0, width[0], height[0]);

			// 2D Renderer
			
			GL11.glMatrixMode(GL11.GL_PROJECTION);
			GL11.glLoadIdentity();
			GL11.glOrtho(0, 1, 1, 0, -100, 100);

			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			GL11.glLoadIdentity();

			GL11.glPushMatrix();

			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glDisable(GL11.GL_LIGHT0);
			
			render2D();

			GL11.glPopMatrix();
			
			// 3D Renderer
			
			GL11.glMatrixMode(GL11.GL_PROJECTION);
			GL11.glLoadIdentity();
			GLMath.createPerspective(80, (double) width[0] / height[0], 0.1, 300);

			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			GL11.glLoadIdentity();

			GL11.glPushMatrix();
			
			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glEnable(GL11.GL_LIGHT0);
			
			Camera c = GameState.getState().getCamera();
			GL11.glTranslated(0, 0, -80);
			GL11.glRotated(-70, 1, 0, 0);
			GL11.glRotated(System.nanoTime() / 1000000000d, 0, 0, 1);

			render3D();

			GL11.glPopMatrix();

			GLFW.glfwPollEvents();
			GLFW.glfwSwapInterval(1);
			GLFW.glfwSwapBuffers(window);
		}
	}
	
	private void render2D() {
		for (Renderer renderer : UIRenderers) {
			renderer.render();
		}
	}
	
	private void render3D() {
		for (Renderer renderer : gameRenderers) {
			renderer.render();
		}
	}
	
	public void close() {
		GLFW.glfwHideWindow(window);
		GLFW.glfwDestroyWindow(window);
		window = -1;
	}
	
	public void addGameRenderer(Renderer renderer) {
		gameRenderers.add(renderer);
	}
	
	public void addUIRenderer(Renderer renderer) {
		UIRenderers.add(renderer);
	}
	
}
