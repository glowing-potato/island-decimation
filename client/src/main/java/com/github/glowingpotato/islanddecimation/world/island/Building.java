package com.github.glowingpotato.islanddecimation.world.island;

import com.github.glowingpotato.islanddecimation.battle.BuildingType;

public class Building {
    public Building(int id, BuildingType buildingType, double x, double y, int level) {
	this.id = id;
	this.buildingType = buildingType;
	this.x = x;
	this.y = y;
	this.level = level;
    }
    private int id;
    private BuildingType buildingType;
    private double x;
    private double y;
    private int level;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public BuildingType getBuildingType() {
	return buildingType;
    }
    public void setBuildingType(BuildingType buildingType) {
	this.buildingType = buildingType;
    }
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
}
