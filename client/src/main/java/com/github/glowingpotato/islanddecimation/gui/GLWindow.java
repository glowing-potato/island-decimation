package com.github.glowingpotato.islanddecimation.gui;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWScrollCallback;
import org.lwjgl.glfw.GLFWScrollCallbackI;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

import com.github.glowingpotato.islanddecimation.render.Camera;
import com.github.glowingpotato.islanddecimation.render.Renderer;
import com.github.glowingpotato.islanddecimation.state.GameState;
import com.glutilities.util.GLMath;
import com.glutilities.util.Vertex3;

public class GLWindow {

	private long window;
	private List<Renderer> gameRenderers = new ArrayList<Renderer>();
	private List<Renderer> UIRenderers = new ArrayList<Renderer>();
	private double[] cpos = new double[] { 0, 0 };

	public GLWindow(int width, int height, String title, long monitor) {
		window = GLFW.glfwCreateWindow(width, height, title, monitor, 0);
		GLFW.glfwShowWindow(window);

		GLFW.glfwSetScrollCallback(window, GLFWScrollCallback.create(new GLFWScrollCallbackI() {

			@Override
			public void invoke(long window, double xoffset, double yoffset) {
				// TODO Auto-generated method stub
				if (yoffset > 0) {
					GameState.getState().getCamera().zoomIn();
				} else if (yoffset < 0) {
					GameState.getState().getCamera().zoomOut();
				}

			}
		}));
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

			Camera c = GameState.getState().getCamera();
			Vertex3 cameraPos = c.getCameraPos();

			GL11.glMatrixMode(GL11.GL_PROJECTION);
			GL11.glLoadIdentity();
			GLMath.createPerspective(80, (double) width[0] / height[0], 0.1, 1000);

			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			GL11.glLoadIdentity();

			GL11.glPushMatrix();

			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glEnable(GL11.GL_LIGHT0);

			double angle = c.getYaw();
			boolean move = false;
			if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_A) == GLFW.GLFW_PRESS) {
				angle -= 90;
				move = true;
			}
			if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_D) == GLFW.GLFW_PRESS) {
				angle += 90;
				move = true;
			}
			Vertex3 dpos = new Vertex3(-Math.sin(angle / 180.0 * Math.PI) * 2, -Math.cos(angle / 180.0 * Math.PI) * 2,
					0);
			if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_W) == GLFW.GLFW_PRESS || move) {
				cameraPos.add(dpos);
			}
			if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_S) == GLFW.GLFW_PRESS) {
				dpos.negate();
				cameraPos.add(dpos);
			}
			double[] curpos = getCursorPos();
			double dmousex = curpos[0] - cpos[0];
			double dmousey = curpos[1] - cpos[1];
			if (GLFW.glfwGetMouseButton(window, GLFW.GLFW_MOUSE_BUTTON_2) == GLFW.GLFW_PRESS) {
				c.addYaw(dmousex / 6f);
				c.addPitch(dmousey / 6f);
			}
			if (c.getPitch() < 20) {
				c.setPitch(20);
			}
			if (c.getPitch() > 85) {
				c.setPitch(85);
			}
			cpos = curpos;
			GL11.glTranslated(0, 0, -(16 + Math.pow(2, c.getZoom() / 4f)));
			GL11.glRotated(c.getPitch() - 90, 1, 0, 0);
			GL11.glRotated(c.getYaw(), 0, 0, 1);
			GL11.glTranslated(cameraPos.getX(), cameraPos.getY(), cameraPos.getZ());

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

	private double[] getCursorPos() {
		double[] x = new double[1];
		double[] y = new double[1];
		GLFW.glfwGetCursorPos(window, x, y);
		return new double[] { x[0], y[0] };
	}
	
	private int[] getWindowSize() {
		int[] x = new int[1];
		int[] y = new int[1];
		GLFW.glfwGetWindowSize(window, x, y);
		return new int[] { x[0], y[0] };
	}
	
	public double getAspect() {
		int[] windowSize = getWindowSize();
		return (double) windowSize[0] / windowSize[1];
	}

}
