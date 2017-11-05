package com.github.glowingpotato.islanddecimation.render;

import com.glutilities.util.Vertex3;

public class Camera {

	private Vertex3 cameraPos;
	private double pitch;
	private double yaw;
	private double roll;
	private int zoom;

	public Camera() {
		cameraPos = new Vertex3(0, 0, 0);
		pitch = 60;
		yaw = 0;
		roll = 0;
		zoom = 32;
	}
	
	public Vertex3 getCameraPos() {
		return cameraPos;
	}
	
	public Vertex3 getPhysicalCameraPos() {
		double zpos = Math.cos(pitch);
		double xpos = zpos * -Math.cos(yaw) * getZDistance();
		double ypos = zpos * -Math.sin(yaw) * getZDistance();
		
		return new Vertex3(xpos * getZDistance(), ypos, zpos);
	}
	
	public double getZDistance() {
		return -(16 + Math.pow(2, zoom / 4f));
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
	
	public int getZoom() {
		return zoom;
	}
	
	public void zoomIn() {
		if (zoom > 8) {
			zoom--;
		}
	}
	
	public void zoomOut() {
		if (zoom < 32) {
			zoom++;
		}
	}

}
