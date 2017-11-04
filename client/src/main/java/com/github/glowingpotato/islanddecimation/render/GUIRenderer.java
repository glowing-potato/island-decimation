package com.github.glowingpotato.islanddecimation.render;

import java.util.List;

import org.lwjgl.opengl.GL11;

import com.github.glowingpotato.islanddecimation.state.GameState;
import com.github.glowingpotato.islanddecimation.view.Island;
import com.github.glowingpotato.islanddecimation.view.Resource;
import com.glutilities.text.Charset;
import com.glutilities.text.FontManager;

public class GUIRenderer extends Renderer {

	@Override
	public void render() {
		// TODO Auto-generated method stub
		List<Island> islands = GameState.getState().getIslands();
		Island i = islands.get(0);
		Resource r = i.getResources();
		int iridium = r.getIridium();
		Charset c = GameState.getState().getFontManager().get("arial");
		FontManager.drawString(c, String.format("Iridium:_%d, Wheat: %d, Wood: %d", r.getIridium(), r.getWheat(), r.getWood()), 0.01, 0.1, 0.005, GameState.getState().getWindow().getAspect(), 0.1);
	}

}
