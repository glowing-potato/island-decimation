package com.github.glowingpotato.islanddecimation.render;

import java.util.List;

import com.github.glowingpotato.islanddecimation.state.GameState;
import com.github.glowingpotato.islanddecimation.world.island.Island;

public class IslandRenderer extends Renderer {

	@Override
	public void render() {
		List<Island> islands = GameState.getState().getIslands();
		for (Island i : islands) {
			// TODO Render islands here
		}
	}

	
	
}
