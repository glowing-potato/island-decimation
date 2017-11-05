package com.github.glowingpotato.islanddecimation.util;

import com.github.glowingpotato.islanddecimation.view.Terrain;
import com.glutilities.util.Vertex3;

public class Raytracer {

	/**
	 * Casts a ray from the starting position in the specified direction normal.
	 * Will continue until the ray either hits the surface or reaches the maximum
	 * distance.
	 * 
	 * @param startPos
	 *            The start position of the ray
	 * @param direction
	 *            The direction the ray should travel
	 * @param terrain
	 *            The terrain map that the ray will intersect
	 * @param delta
	 *            The amount of distance the ray should move
	 * @param max
	 *            The maximum the distance the ray will travel before calling it
	 *            quits
	 * @return The vertex position of where the ray hits the surface, or null if it
	 *         never hits anything
	 */
	public static Vertex3 raytrace(Vertex3 startPos, Vertex3 direction, Terrain terrain, float delta, float max) {
		Vertex3 scaledDirection = new Vertex3(direction.getX(), direction.getY(), direction.getZ());
		scaledDirection.scale(new Vertex3(delta, delta, delta));
		Vertex3 newPos = startPos;
		float distance = 0;
		do {
			float height = terrain.get((int) newPos.getX(), (int) newPos.getY());
			if (newPos.getZ() < height) {
				return new Vertex3(newPos.getX(), newPos.getY(), height);
			}
			distance += delta;
			newPos.add(direction);
		} while (distance < max);
		return null;
	}

}
