package com.github.glowingpotato.islanddecimation.world.island;

import java.util.ArrayList;

public class Terrain {
	
	private ArrayList<Double[]> terrain = new ArrayList<Double[]>();
	
    public Terrain(ArrayList<Double[]> terrain) {
    	this.terrain = terrain;
    }
    
    public void update(Terrain terrain) {
    	if(terrain.getTerrain() != null)
    		setTerrain(terrain.getTerrain());
    }

	public ArrayList<Double[]> getTerrain() {
		return terrain;
	}

	public void setTerrain(ArrayList<Double[]> terrain) {
		this.terrain = terrain;
	}
}
