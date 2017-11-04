package com.github.glowingpotato.islanddecimation.render;

import org.lwjgl.opengl.GL11;

import com.github.glowingpotato.islanddecimation.state.GameState;
import com.github.glowingpotato.islanddecimation.view.Troop;
import com.glutilities.model.Model;
import com.glutilities.util.Vertex3;

public class TroopRenderer extends Renderer {
	
	public TroopRenderer() {
		Model model = GameState.getState().getModelManager().get("resources/wall-e.obj");
		for(Troop troop : GameState.getState().getTroops()) {
			troop.animate(0.5f);
			Vertex3 troopPosition = troop.getPosition();
			GL11.glTranslated(troopPosition.getX(), troopPosition.getX(), troopPosition.getZ());
		}
	}

	@Override
	public void render() {
		for(Troop troop : GameState.getState().getTroops()) {
			troop.animate(0.5f);
			GL11.glTranslated(troop.getDeltaX(), troop.getDeltaX(), troop.getDeltaZ());
		}
	}

}
