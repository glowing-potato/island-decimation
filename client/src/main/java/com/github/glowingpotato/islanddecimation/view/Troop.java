package com.github.glowingpotato.islanddecimation.view;

import com.glutilities.util.Vertex2;

public class Troop {
	
	private TroopType troopType;
	private Vertex2 position;
	private Vertex2 targetPosition;
	private Integer islandIndex;
	
	public Troop(TroopType troopType, Vertex2 position, Vertex2 targetPosition, Integer islandIndex) {
		this.troopType = troopType;
		this.position = position;
		this.targetPosition = targetPosition;
		this.islandIndex = islandIndex;
	}
	
	public void update(Troop troop) {
		if(troop.getTroopType() != null)
			setTroopType(troop.getTroopType());
		if(troop.getPosition() != null)
			setPosition(troop.getPosition());
		if(troop.getTargetPosition() != null)
			setTargetPosition(troop.getTargetPosition());
		if(troop.getIslandIndex() != null)
			setIslandIndex(troop.getIslandIndex());
	}

	public TroopType getTroopType() {
		return troopType;
	}

	public void setTroopType(TroopType troopType) {
		this.troopType = troopType;
	}

	public Vertex2 getPosition() {
		return position;
	}

	public void setPosition(Vertex2 position) {
		this.position = position;
	}

	public Vertex2 getTargetPosition() {
		return targetPosition;
	}

	public void setTargetPosition(Vertex2 targetPosition) {
		this.targetPosition = targetPosition;
	}

	public Integer getIslandIndex() {
		return islandIndex;
	}

	public void setIslandIndex(Integer islandIndex) {
		this.islandIndex = islandIndex;
	}
}
