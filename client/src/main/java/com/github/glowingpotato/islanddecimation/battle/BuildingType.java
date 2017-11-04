package com.github.glowingpotato.islanddecimation.battle;

public enum BuildingType {

	KING_TOWER("king_tower");

	private String modelName;

	private BuildingType(String modelName) {
		this.modelName = modelName;
	}

	public String getModelName() {
		return modelName;
	}

}
