package com.github.glowingpotato.islanddecimation.world;

import com.github.glowingpotato.islanddecimation.world.island.Island;

public class User {
    private int id;
    private World world;
    private Island island;
    private String username;
    private String password;
    private double score;
    private double xp;
    
    public int getID() {
	return id;
    }
    public void setID(int id) {
	this.id = id;
    }
    public World getWorld() {
	return world;
    }
    public void setWorld(World world) {
	this.world = world;
    }
    public Island getIsland() {
	return island;
    }
    public void setIsland(Island island) {
	this.island = island;
    }
    public String getUsername() {
	return username;
    }
    public void setUsername(String username) {
	this.username = username;
    }
    public String getPassword() {
	return password;
    }
    public void setPassword(String password) {
	this.password= password;
    }
    public double getScore() {
	return score;
    }
    public void setScore(double score) {
	this.score = score;
    }
    public double getXP() {
	return xp;
    }
    public void setXP(double xp) {
	this.xp = xp;
    }
}
