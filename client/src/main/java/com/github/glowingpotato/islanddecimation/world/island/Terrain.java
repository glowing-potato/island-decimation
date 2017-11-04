package com.github.glowingpotato.islanddecimation.world.island;

public class Terrain {
    public Terrain(float[] shape) {
	this.shape = shape;
    }
    private float[] shape;
    public float[] getShape() {
	return shape;
    }
    public void setShape(float[] shape) {
	this.shape = shape;
    }
}
