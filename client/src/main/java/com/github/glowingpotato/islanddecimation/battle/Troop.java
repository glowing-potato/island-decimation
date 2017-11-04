package com.github.glowingpotato.islanddecimation.battle;

public class Troop {
	
	private TroopType troopType;
	private Double x;
	private Double y;
	private Double targetX;
	private Double targetY;
	private Integer islandIndex;
	
	public Troop(TroopType troopType, Double x, Double y, Double targetX, Double targetY, Integer islandIndex) {
		this.troopType = troopType;
		this.x = x;
		this.y = y;
		this.targetX = targetX;
		this.targetY = targetY;
		this.islandIndex = islandIndex;
	}
	
	public void update(Troop troop) {
		if(troop.getTroopType() != null)
			setTroopType(troop.getTroopType());
		if(troop.getX() != null)
			setX(troop.getX());
		if(troop.getY() != null)
			setY(troop.getY());
		if(troop.getTargetX() != null)
			setTargetX(troop.getTargetX());
		if(troop.getTargetY() != null)
			setTargetY(troop.getTargetY());
		if(troop.getIslandIndex() != null)
			setIslandIndex(troop.getIslandIndex());
	}

	public TroopType getTroopType() {
		return troopType;
	}

	public void setTroopType(TroopType troopType) {
		this.troopType = troopType;
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

	public Double getTargetX() {
		return targetX;
	}

	public void setTargetX(Double targetX) {
		this.targetX = targetX;
	}

	public Double getTargetY() {
		return targetY;
	}

	public void setTargetY(Double targetY) {
		this.targetY = targetY;
	}

	public Integer getIslandIndex() {
		return islandIndex;
	}

	public void setIslandIndex(Integer islandIndex) {
		this.islandIndex = islandIndex;
	}
}
