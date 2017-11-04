package com.github.glowingpotato.islanddecimation.view;

import java.util.ArrayList;

public class ViewModel {
	
	private Island userIsland;
	private ArrayList<Island> battlingIslands = new ArrayList<Island>();
	private ArrayList<Troop> troops = new ArrayList<Troop>();
	private ViewState state;
	
	public ViewModel(Island userIsland, ArrayList<Island> battlingIslands, ArrayList<Troop> troops, ViewState state) {
		this.userIsland = userIsland;
		this.battlingIslands = battlingIslands;
		this.troops = troops;
		this.state = state;
	}
	
	public void update(ViewModel viewModel) {
		if(viewModel.getUserIsland() != null)
			setUserIsland(viewModel.getUserIsland());
		if(viewModel.getBattlingIslands() != null)
			setBattlingIslands(viewModel.getBattlingIslands());
		if(viewModel.getTroops() != null)
			setTroops(viewModel.getTroops());
		if(viewModel.getState() != null)
			setState(viewModel.getState());
	}

	public Island getUserIsland() {
		return userIsland;
	}

	public void setUserIsland(Island userIsland) {
		this.userIsland = userIsland;
	}

	public ArrayList<Island> getBattlingIslands() {
		return battlingIslands;
	}

	public void setBattlingIslands(ArrayList<Island> battlingIslands) {
		this.battlingIslands = battlingIslands;
	}

	public ArrayList<Troop> getTroops() {
		return troops;
	}

	public void setTroops(ArrayList<Troop> troops) {
		this.troops = troops;
	}

	public ViewState getState() {
		return state;
	}

	public void setState(ViewState state) {
		this.state = state;
	}
}
