package com.github.glowingpotato.islanddecimation.world;

public class World {
    public World(int id, long startTime) {
	this.id = id;
	this.startTime = startTime;
    }
    private int id;
    private long startTime;
    public int getID() {
	return id;
    }
    public void setID(int id) {
	this.id = id;
    }
    public long getstartTime() {
	return startTime;
    }
    public void startTIme(long startTime) {
	this.startTime = startTime;
    }
}
