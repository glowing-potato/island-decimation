package com.github.glowingpotato.islanddecimation.render;

import java.util.List;

import org.lwjgl.opengl.GL11;

import com.github.glowingpotato.islanddecimation.state.GameState;
import com.github.glowingpotato.islanddecimation.world.island.Island;
import com.glutilities.util.Vertex3;

public class IslandRenderer extends Renderer {

	public static final int ISLAND_SIZE = 256;
	public static final int ISLAND_RADIUS = ISLAND_SIZE / 2;

	@Override
	public void render() {
		List<Island> islands = GameState.getState().getIslands();
		for (Island i : islands) {
			// TODO Render islands here
			
			GL11.glBegin(GL11.GL_QUADS);
			//GL11.glColor4d(1, 1, 1, 0.4);
			
			float[] vertices = i.getShape().getShape();
			for (int index = 0; index < vertices.length - IslandRenderer.ISLAND_SIZE - 1; index++) {
				int x = index % IslandRenderer.ISLAND_SIZE;
				int y = index / IslandRenderer.ISLAND_SIZE;
				// GL11.Material
				//float x2y1 = get(x + 1, y, vertices);
				//float x2y3 = get(x + 1, y + 2, vertices);
				//float x1y2 = get(x, y + 1, vertices);
				//float x3y2 = get(x + 2, y + 1, vertices);
				//Vertex3 a1 = new Vertex3(0, 2, x2y3 - x2y1);
				//a1.crossProduct(new Vertex3(2, 0, x3y2 - x1y2));
				//a1.normalize();
				//a1.negate();
				float g = get(x, y, vertices);
//				GL11.glMaterialfv(GL11.GL_FRONT, GL11.GL_AMBIENT | GL11.GL_DIFFUSE,
//						new float[] { ipol(0.2f, 0.8f, g), ipol(0.8f, 0.8f, g), ipol(0.2f, 0.4f, g), 1 });
				material(ipol(0.2f, 0.8f, g), ipol(0.8f, 0.8f, g), ipol(0.2f, 0.4f, g), 1);
				//GL11.glNormal3d(a1.getX(), a1.getY(), a1.getZ());
				normal(x, y, vertices);
				GL11.glVertex3f(index % IslandRenderer.ISLAND_SIZE - ISLAND_RADIUS,
						index / (float) IslandRenderer.ISLAND_SIZE - ISLAND_RADIUS, vertices[index]);
				normal(x, y + 1, vertices);
				GL11.glVertex3f(index % IslandRenderer.ISLAND_SIZE - ISLAND_RADIUS,
						index / (float) IslandRenderer.ISLAND_SIZE + 1 - ISLAND_RADIUS,
						vertices[index + IslandRenderer.ISLAND_SIZE]);
				normal(x + 1, y + 1, vertices);
				GL11.glVertex3f(index % IslandRenderer.ISLAND_SIZE + 1 - ISLAND_RADIUS,
						index / (float) IslandRenderer.ISLAND_SIZE + 1 - ISLAND_RADIUS,
						vertices[index + IslandRenderer.ISLAND_SIZE + 1]);
				normal(x + 1, y, vertices);
				GL11.glVertex3f(index % IslandRenderer.ISLAND_SIZE + 1 - ISLAND_RADIUS,
						index / (float) IslandRenderer.ISLAND_SIZE - ISLAND_RADIUS, vertices[index + 1]);
			}
			material(0, 0, 1, 0.6f);
			GL11.glVertex2d(-1000, -1000);
			GL11.glVertex2d(-1000, 1000);
			GL11.glVertex2d(1000, 1000);
			GL11.glVertex2d(1000, -1000);
			GL11.glEnd();
		}
	}
	
	private void material(float r, float g, float b, float a) {
		GL11.glMaterialfv(GL11.GL_FRONT, GL11.GL_AMBIENT | GL11.GL_DIFFUSE,
				new float[] { r, g, b, a });
	}
	
	private void normal(int x, int y, float[] vertices) {
		float x2y1 = get(x + 1, y, vertices);
		float x2y3 = get(x + 1, y + 2, vertices);
		float x1y2 = get(x, y + 1, vertices);
		float x3y2 = get(x + 2, y + 1, vertices);
		Vertex3 a1 = new Vertex3(0, 2, x2y3 - x2y1);
		a1.crossProduct(new Vertex3(2, 0, x3y2 - x1y2));
		a1.normalize();
		a1.negate();
		GL11.glNormal3d(a1.getX(), a1.getY(), a1.getZ());
	}

	private float get(int x, int y, float[] vertices) {
		if (x >= 0 && x < IslandRenderer.ISLAND_SIZE && y >= 0 && y < IslandRenderer.ISLAND_SIZE) {
			return vertices[y * IslandRenderer.ISLAND_SIZE + x];
		}
		return 0;
	}

	private float ipol(float a, float b, float t) {
		t = Math.max(0, Math.min(t, 1));
		return (a * t) + b * (1 - t);
	}

}
