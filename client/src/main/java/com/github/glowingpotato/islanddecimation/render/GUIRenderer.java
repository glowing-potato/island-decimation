package com.github.glowingpotato.islanddecimation.render;

import java.util.List;

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
		System.out.println(islands);
		Island i = islands.get(0);
		System.out.println(i);
		Resource r = i.getResources();
		System.out.println(r);
		int iridium = r.getIridium();
		Charset c = GameState.getState().getFontManager().get("arial");
		FontManager.drawString(c, "Testing", 0.1, 0.1, 0.1, 16d / 9);
	}

}
