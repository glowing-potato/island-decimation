package com.github.glowingpotato.islanddecimation.render;

import org.lwjgl.opengl.GL11;
import com.github.glowingpotato.islanddecimation.state.GameState;
import com.glutilities.model.Model;

public class TroopRendering {
    public TroopRendering() {
	Model model = GameState.getState().getModelManager().get("Model A");
	GL11.glTranslated(5, 5, 0);
	model.draw();
    }
}
