package com.github.glowingpotato.islanddecimation.view;

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
