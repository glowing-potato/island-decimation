package com.github.glowingpotato.islanddecimation.view;

public class Resource {
	
	private Integer wood;
	private Integer wheat;
	private Integer iridium;

	public Resource(int wood, int wheat, int iridium) {
		this.wood = wood;
		this.wheat = wheat;
		this.iridium = iridium;
	}
	
	public void update(Resource resources) {
		if(resources.getWood() != null)
			setWood(resources.getWood());
		if(resources.getWheat() != null)
			setWheat(resources.getWheat());
		if(resources.getIridium() != null)
			setIridium(resources.getIridium());
	}
	
	public Integer getWood() {
		return wood;
	}

	public void setWood(Integer wood) {
		this.wood = wood;
	}

	public Integer getWheat() {
		return wheat;
	}

	public void setWheat(Integer wheat) {
		this.wheat = wheat;
	}

	public Integer getIridium() {
		return iridium;
	}

	public void setIridium(Integer iridium) {
		this.iridium = iridium;
	}
}
