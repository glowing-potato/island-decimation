package com.github.glowingpotato.islanddecimation.state;

import java.util.ArrayList;
import java.util.List;

import com.github.glowingpotato.islanddecimation.render.Camera;
import com.github.glowingpotato.islanddecimation.world.User;
import com.github.glowingpotato.islanddecimation.world.island.Island;

public class GameState {

	public GameState(List<Island> islands, User user, Camera camera) {
		this.islands = islands;
		this.user = user;
		this.camera = camera;
	}

	private static GameState state = new GameState(new ArrayList<Island>(), null, new Camera());
	private List<Island> islands;
	private User user;
	private Camera camera;

	public static GameState getState() {
		return state;
	}

	public List<Island> getIslands() {
		return islands;
	}

	public User getUser() {
		return user;
	}
	
	public Camera getCamera() {
		return camera;
	}

}
