package com.github.glowingpotato.islanddecimation.view;

import java.util.ArrayList;
import java.util.List;

public class Terrain {
	
	private List<Float> terrain = new ArrayList<Float>();
	
    public Terrain(List<Float> list) {
    	this.terrain = list;
    }
    
    public void update(Terrain terrain) {
    	if(terrain.getTerrain() != null)
    		setTerrain(terrain.getTerrain());
    }

	public List<Float> getTerrain() {
		return terrain;
	}
	
	public float[] getTerrainAsArray() {
		float[] result = new float[terrain.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = terrain.get(i);
		}
		return result;
	}

	public void setTerrain(List<Float> terrain) {
		this.terrain = terrain;
	}
}
