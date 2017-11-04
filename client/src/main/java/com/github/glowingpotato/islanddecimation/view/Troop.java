package com.github.glowingpotato.islanddecimation.view;

import com.github.glowingpotato.islanddecimation.state.GameState;
import com.glutilities.util.Vertex2;
import com.glutilities.util.Vertex3;

public class Troop {
	
	private TroopType troopType;
	private Vertex3 position;
	private Vertex2 targetPosition;
	private Integer islandIndex;
	private Integer health;
	
	public Troop(TroopType troopType, Vertex3 position, Vertex2 targetPosition, Integer islandIndex, Integer health) {
		this.troopType = troopType;
		this.position = position;
		this.targetPosition = targetPosition;
		this.islandIndex = islandIndex;
		this.health = health;
	}
	
	public void animate(float speed) {
		double deltaX = targetPosition.getX() - position.getX();
		double deltaY = targetPosition.getY() - position.getY();
		if(deltaX < 5 || deltaY < 5) {
			health--;
		}
		double normalizer = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
		double normalX = deltaX / normalizer;
		double normalY = deltaY / normalizer;
		float zLevel= GameState.getState().getIslands().get(0).getTerrain().get((int) getPosition().getX(), (int) getPosition().getY());
		zLevel = (zLevel == Float.NaN) ? 0 : zLevel;
		setPosition(new Vertex3(getPosition().getX() + normalX, getPosition().getY() + normalY, zLevel));
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
		if(troop.getHealth() != null)
			setHealth(troop.getHealth());
	}

	public TroopType getTroopType() {
		return troopType;
	}

	public void setTroopType(TroopType troopType) {
		this.troopType = troopType;
	}

	public Vertex3 getPosition() {
		return position;
	}

	public void setPosition(Vertex3 position) {
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

	public Integer getHealth() {
		return health;
	}

	public void setHealth(Integer health) {
		this.health = health;
	}
}
