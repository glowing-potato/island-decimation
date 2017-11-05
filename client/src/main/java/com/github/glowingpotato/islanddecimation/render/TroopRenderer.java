package com.github.glowingpotato.islanddecimation.render;

import org.lwjgl.opengl.GL11;

import com.github.glowingpotato.islanddecimation.state.GameState;
import com.github.glowingpotato.islanddecimation.view.Troop;
import com.glutilities.model.Model;
import com.glutilities.util.Vertex3;

public class TroopRenderer extends Renderer {

	// public TroopRenderer() {
	//// Model model = GameState.getState().getModelManager().get("test");
	//// model.draw();
	//// for(Troop troop : GameState.getState().getTroops()) {
	//// troop.animate(0.5f);
	//// Vertex3 troopPosition = troop.getPosition();
	//// GL11.glTranslated(troopPosition.getX(), troopPosition.getX(),
	// troopPosition.getZ());
	//// }
	// }

	@Override
	public void render() {
		Model model = GameState.getState().getModelManager().get("wall-e");

		for (Troop troop : GameState.getState().getTroops()) {
			GL11.glPushMatrix();
			troop.animate();
			Vertex3 troopPosition = troop.getPosition();
			GL11.glTranslated(troopPosition.getX(), troopPosition.getY(), troopPosition.getZ());
			GL11.glRotated(Math.atan2(troop.getDeltaY(), troop.getDeltaX()) / Math.PI * 180, 0, 0, 1);
			GL11.glRotated(90, 1, 0, 0);
			GL11.glScaled(0.5, 0.5, 0.5);
			model.draw();
			GL11.glPopMatrix();
			// GL11.glTranslated(troop.getDeltaX(), troop.getDeltaX(), troop.getDeltaZ());
		}
	}

}
