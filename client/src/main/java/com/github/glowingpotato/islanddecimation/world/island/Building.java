package com.github.glowingpotato.islanddecimation.world.island;

import com.github.glowingpotato.islanddecimation.battle.BuildingType;

public class Building {
	
	private BuildingType buildingType;
	private Double x;
	private Double y;
	private Integer level;
	
	public Building(BuildingType buildingType, Double x, Double y, Integer level) {
		this.buildingType = buildingType;
		this.x = x;
		this.y = y;
		this.level = level;
	}
	
	public void update(Building building) {
		if(building.buildingType != null)
			setBuildingType(building.getBuildingType());
		if(building.getX() != null)
			setX(building.getX());
		if(building.getY() != null)
			setY(building.getY());
		if(building.getLevel() != null)
			setLevel(building.getLevel());
	}
	
	public BuildingType getBuildingType() {
		return buildingType;
	}

	public void setBuildingType(BuildingType buildingType) {
		this.buildingType = buildingType;
	}

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
}
