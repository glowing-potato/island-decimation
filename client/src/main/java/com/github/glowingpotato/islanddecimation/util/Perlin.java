package com.github.glowingpotato.islanddecimation.util;

import java.util.Random;

public class Perlin {

	/**
	 * Perlin.cpp
	 *
	 * Copyright Chris Little 2012 Author: Chris Little
	 * 
	 * Adapted for Java by Hanavan Kuhn
	 */

	private int RAND_MAX = Integer.MAX_VALUE;

	private Random rnd;

	private int[] p;
	private double[] Gx;
	private double[] Gy;
	private double[] Gz;

	public Perlin() {
		// srand(time(NULL));
		rnd = new Random();

		p = new int[256];
		Gx = new double[256];
		Gy = new double[256];
		Gz = new double[256];

		for (int i = 0; i < 256; ++i) {
			p[i] = i;

			Gx[i] = ((double) (rnd.nextInt()) / (RAND_MAX / 2)) - 1.0f;
			Gy[i] = ((double) (rnd.nextInt()) / (RAND_MAX / 2)) - 1.0f;
			Gz[i] = ((double) (rnd.nextInt()) / (RAND_MAX / 2)) - 1.0f;
		}

		int j = 0;
		int swp = 0;
		for (int i = 0; i < 256; i++) {
			j = rnd.nextInt() & 255;

			swp = p[i];
			p[i] = p[j];
			p[j] = swp;
		}
	}

	public double noise(double sample_x, double sample_y, double sample_z) {
		// Unit cube vertex coordinates surrounding the sample point
		int x0 = (int) (Math.floor(sample_x));
		int x1 = x0 + 1;
		int y0 = (int) (Math.floor(sample_y));
		int y1 = y0 + 1;
		int z0 = (int) (Math.floor(sample_z));
		int z1 = z0 + 1;

		// Determine sample point position within unit cube
		double px0 = sample_x - x0;
		double px1 = px0 - 1.0f;
		double py0 = sample_y - y0;
		double py1 = py0 - 1.0f;
		double pz0 = sample_z - z0;
		double pz1 = pz0 - 1.0f;

		// Compute dot product between gradient and sample position vector
		int gIndex = p[(x0 + p[(y0 + p[z0 & 255]) & 255]) & 255];
		double d000 = Gx[gIndex] * px0 + Gy[gIndex] * py0 + Gz[gIndex] * pz0;
		gIndex = p[(x1 + p[(y0 + p[z0 & 255]) & 255]) & 255];
		double d001 = Gx[gIndex] * px1 + Gy[gIndex] * py0 + Gz[gIndex] * pz0;

		gIndex = p[(x0 + p[(y1 + p[z0 & 255]) & 255]) & 255];
		double d010 = Gx[gIndex] * px0 + Gy[gIndex] * py1 + Gz[gIndex] * pz0;
		gIndex = p[(x1 + p[(y1 + p[z0 & 255]) & 255]) & 255];
		double d011 = Gx[gIndex] * px1 + Gy[gIndex] * py1 + Gz[gIndex] * pz0;

		gIndex = p[(x0 + p[(y0 + p[z1 & 255]) & 255]) & 255];
		double d100 = Gx[gIndex] * px0 + Gy[gIndex] * py0 + Gz[gIndex] * pz1;
		gIndex = p[(x1 + p[(y0 + p[z1 & 255]) & 255]) & 255];
		double d101 = Gx[gIndex] * px1 + Gy[gIndex] * py0 + Gz[gIndex] * pz1;

		gIndex = p[(x0 + p[(y1 + p[z1 & 255]) & 255]) & 255];
		double d110 = Gx[gIndex] * px0 + Gy[gIndex] * py1 + Gz[gIndex] * pz1;
		gIndex = p[(x1 + p[(y1 + p[z1 & 255]) & 255]) & 255];
		double d111 = Gx[gIndex] * px1 + Gy[gIndex] * py1 + Gz[gIndex] * pz1;

		// Interpolate dot product values at sample point using polynomial
		// interpolation 6x^5 - 15x^4 + 10x^3
		double wx = ((6 * px0 - 15) * px0 + 10) * px0 * px0 * px0;
		double wy = ((6 * py0 - 15) * py0 + 10) * py0 * py0 * py0;
		double wz = ((6 * pz0 - 15) * pz0 + 10) * pz0 * pz0 * pz0;

		double xa = d000 + wx * (d001 - d000);
		double xb = d010 + wx * (d011 - d010);
		double xc = d100 + wx * (d101 - d100);
		double xd = d110 + wx * (d111 - d110);
		double ya = xa + wy * (xb - xa);
		double yb = xc + wy * (xd - xc);
		double value = ya + wz * (yb - ya);

		return value;
	}

}
