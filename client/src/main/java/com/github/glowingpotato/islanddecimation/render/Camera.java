package com.github.glowingpotato.islanddecimation.render;

import com.glutilities.util.Vertex3;

public class Camera {

	private Vertex3 cameraPos;
	private double pitch;
	private double yaw;
	private double roll;

	public Vertex3 getCameraPos() {
		return cameraPos;
	}

	public void setCameraPos(Vertex3 cameraPos) {
		this.cameraPos = cameraPos;
	}

	public double getPitch() {
		return pitch;
	}

	public void setPitch(double pitch) {
		this.pitch = pitch;
	}
	
	public void addPitch(double pitch) {
		this.pitch += pitch;
	}

	public double getYaw() {
		return yaw;
	}

	public void setYaw(double yaw) {
		this.yaw = yaw;
	}
	
	public void addYaw(double yaw) {
		this.yaw += yaw;
	}

	public double getRoll() {
		return roll;
	}

	public void setRoll(double roll) {
		this.roll = roll;
	}
	
	public void addRoll(double roll) {
		this.roll += roll;
	}

}
