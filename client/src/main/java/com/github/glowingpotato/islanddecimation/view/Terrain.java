package com.github.glowingpotato.islanddecimation.view;

import java.util.ArrayList;
import com.glutilities.util.Vertex3;

public class Terrain {
	
	private ArrayList<Vertex3> terrain = new ArrayList<Vertex3>();
	
    public Terrain(ArrayList<Vertex3> terrain) {
    	this.terrain = terrain;
    }
    
    public void update(Terrain terrain) {
    	if(terrain.getTerrain() != null)
    		setTerrain(terrain.getTerrain());
    }

	public ArrayList<Vertex3> getTerrain() {
		return terrain;
	}

	public void setTerrain(ArrayList<Vertex3> terrain) {
		this.terrain = terrain;
	}
}
