package com.github.glowingpotato.islanddecimation.render;

import java.util.List;

import org.lwjgl.opengl.GL11;

import com.github.glowingpotato.islanddecimation.state.GameState;
import com.github.glowingpotato.islanddecimation.world.island.Island;

public class IslandRenderer extends Renderer {

	@Override
	public void render() {
		List<Island> islands = GameState.getState().getIslands();
		for (Island i : islands) {
			// TODO Render islands here
			
			GL11.glBegin(GL11.GL_QUADS);
			float[] vertices = i.getShape().getShape();
			for (int index = 0; index < vertices.length - 65; index++) {
				
				//GL11.Material
				float x1y1 = vertices[index];
				float x1y2 = vertices[index + 64];
				float x2y1 = vertices[index + 1];
				float x2y2 = vertices[index + 65];
				GL11.glMaterialfv(GL11.GL_FRONT, GL11.GL_AMBIENT, new float[] {
						ipol(0.2f, 0.8f, x1y1),
						ipol(0.8f, 0.8f, x1y1),
						ipol(0.2f, 0.4f, x1y1), 1 });
				GL11.glNormal3d(x1y2 - x1y1, x2y2 - x2y1, 0.7);
				GL11.glVertex3f(index % 64, index / 64f, vertices[index]);
				GL11.glVertex3f(index % 64, index / 64f + 1, vertices[index + 64]);
				GL11.glVertex3f(index % 64 + 1, index / 64f + 1, vertices[index + 65]);
				GL11.glVertex3f(index % 64 + 1, index / 64f, vertices[index + 1]);
			}
			GL11.glEnd();
		}
	}
	
	private float ipol(float a, float b, float t) {
		t = Math.max(0, Math.min(t, 1));
		return (a * t) + b * (1 - t);
	}

}
