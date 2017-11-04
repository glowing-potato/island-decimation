package com.github.glowingpotato.islanddecimation.view;

public class Island {
	
	private Double score;
	private Double experience;
	private Resource resources;
	private Terrain terrain;
	private Double angle;
	
	public Island(Double score, Double experience, Resource resources, Terrain terrain, Double angle) {
		this.score = score;
		this.experience = experience;
		this.resources = resources;
		this.terrain = terrain;
		this.angle = angle;
	}
	
	public void update(Island island) {
		if(island.getScore() != null)
			setScore(island.getScore());
		if(island.getExperience() != null)
			setExperience(island.getExperience());
		if(island.getResources() != null)
			setResources(island.getResources());
		if(island.getTerrain() != null)
			setTerrain(island.getTerrain());
		if(island.getAngle() != null)
			setAngle(island.getAngle());
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Double getExperience() {
		return experience;
	}

	public void setExperience(Double experience) {
		this.experience = experience;
	}

	public Resource getResources() {
		return resources;
	}

	public void setResources(Resource resources) {
		this.resources = resources;
	}

	public Terrain getTerrain() {
		return terrain;
	}

	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}

	public Double getAngle() {
		return angle;
	}

	public void setAngle(Double angle) {
		this.angle = angle;
	}
}
