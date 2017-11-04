package com.github.glowingpotato.islanddecimation.network;

import java.util.Map;

import com.github.glowingpotato.islanddecimation.state.GameState;
import com.google.gson.Gson;

public class ClientService {
	
	
	public ClientService() {
		//TODO figure out what this class actually needs to do
	}
	
	public static void update(String json) {
		Map<String, Object> jsonTranslation = readJson(json);
		for(String key : jsonTranslation.keySet()) {
			updateItem(key, jsonTranslation.get(key));
		}
	}
	
	private static void updateItem(String key, Object object) {
		//TODO put some actual code here
		GameState.getState().getIslands();
	}

	private static Map<String, Object> readJson(String jsonContent) {
		Map<String, Object> jsonTranslation = new Gson().fromJson(jsonContent, Map.class);
		return jsonTranslation;
	}
}
