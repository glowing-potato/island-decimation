package com.github.glowingpotato.islanddecimation.battle;

public enum TroopType {

	ARCHER("archer");

	private String modelName;

	private TroopType(String modelName) {
		this.modelName = modelName;
	}

	public String getModelName() {
		return modelName;
	}
}
