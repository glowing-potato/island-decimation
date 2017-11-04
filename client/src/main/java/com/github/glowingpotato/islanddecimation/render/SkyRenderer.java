package com.github.glowingpotato.islanddecimation.render;

import org.lwjgl.opengl.GL11;

public class SkyRenderer extends Renderer {

	@Override
	public void render() {
		// TODO Auto-generated method stub
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glColor3d(0.3, 0.3, 1);
		GL11.glVertex3d(0, 0, -100);
		GL11.glVertex3d(1, 0, -100);
		GL11.glColor3d(0.9, 0.9, 1);
		GL11.glVertex3d(1, 1, -100);
		GL11.glVertex3d(0, 1, -100);
		GL11.glEnd();
	}

}
