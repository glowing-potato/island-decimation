package com.github.glowingpotato.islanddecimation.state;

import java.util.List;
import com.github.glowingpotato.islanddecimation.world.User;
import com.github.glowingpotato.islanddecimation.world.island.Island;

public class GameState {

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
