package com.github.glowingpotato.islanddecimation.state;

import java.util.List;

import com.github.glowingpotato.islanddecimation.view.Island;
import com.github.glowingpotato.islanddecimation.world.User;

public class GameState {

	public GameState(List<Island> islands, User user) {
	this.islands = islands;
	this.user = user;
    }

	private static GameState state;
	private List<Island> islands;
	private User user;
	
	public static GameState getState() {
		return state;
	}
	
	public List<Island> getIslands() {
		return islands;
	}
	
	public User getUser() {
		return user;
	}
	
}
