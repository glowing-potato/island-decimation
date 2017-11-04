package com.github.glowingpotato.islanddecimation.state;

import java.util.ArrayList;
import java.util.List;

import com.github.glowingpotato.islanddecimation.gui.GLWindow;
import com.github.glowingpotato.islanddecimation.render.Camera;
import com.github.glowingpotato.islanddecimation.view.Island;
import com.github.glowingpotato.islanddecimation.view.Troop;
import com.github.glowingpotato.islanddecimation.world.User;
import com.glutilities.model.ModelManager;
import com.glutilities.text.FontManager;
import com.glutilities.texture.TextureManager;

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
	private GLWindow window;
	private FontManager fontManager = new FontManager();
	private ModelManager modelManager = new ModelManager();
	private TextureManager textureManager = new TextureManager();
	private List<Troop> troops;
	
	
	public List<Troop> getTroops() {
		return troops;
	}

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
	
	public GLWindow getWindow() {
		return window;
	}
	
	public void setWindow(GLWindow window) {
		this.window = window;
	}
	
	public FontManager getFontManager() {
		return fontManager;
	}
	
	public ModelManager getModelManager() {
		return modelManager;
	}
	
	public TextureManager getTextureManager() {
		return textureManager;
	}

}
