package com.github.glowingpotato.islanddecimation.view;

import java.util.ArrayList;

public class ViewModel {
	
	private ArrayList<Island> userIslands = new ArrayList<Island>();
	private ArrayList<Island> battlingIslands = new ArrayList<Island>();
	private ArrayList<Troop> troops = new ArrayList<Troop>();
	private ViewState state;
	
	public ViewModel(ArrayList<Island> userIslands, ArrayList<Island> battlingIslands, ArrayList<Troop> troops, ViewState state) {
		this.userIslands = userIslands;
		this.battlingIslands = battlingIslands;
		this.troops = troops;
		this.state = state;
	}
	
	public void update(ViewModel viewModel) {
		if(viewModel.getUserIslands() != null)
			setUserIslands(viewModel.getUserIslands());
		if(viewModel.getBattlingIslands() != null)
			setBattlingIslands(viewModel.getBattlingIslands());
		if(viewModel.getTroops() != null)
			setTroops(viewModel.getTroops());
		if(viewModel.getState() != null)
			setState(viewModel.getState());
	}

	public ArrayList<Island> getUserIslands() {
		return userIslands;
	}

	public void setUserIslands(ArrayList<Island> userIslands) {
		this.userIslands = userIslands;
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
