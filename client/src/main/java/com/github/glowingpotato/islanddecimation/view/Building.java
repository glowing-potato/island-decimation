package com.github.glowingpotato.islanddecimation.view;

import com.glutilities.util.Vertex2;

public class Building {
	
	private BuildingType buildingType;
	private Vertex2 position;
	private Integer level;
	
	public Building(BuildingType buildingType, Vertex2 position, Integer level) {
		this.buildingType = buildingType;
		this.position = position;
		this.level = level;
	}
	
	public void update(Building building) {
		if(building.buildingType != null)
			setBuildingType(building.getBuildingType());
		if(building.getPosition() != null)
			setPosition(building.getPosition());
		if(building.getLevel() != null)
			setLevel(building.getLevel());
	}
	
	public BuildingType getBuildingType() {
		return buildingType;
	}

	public void setBuildingType(BuildingType buildingType) {
		this.buildingType = buildingType;
	}

	public Vertex2 getPosition() {
		return position;
	}

	public void setPosition(Vertex2 position) {
		this.position = position;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
}
