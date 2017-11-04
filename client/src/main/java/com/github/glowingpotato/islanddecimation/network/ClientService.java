package com.github.glowingpotato.islanddecimation.network;

import com.github.glowingpotato.islanddecimation.view.ViewModel;
import com.google.gson.Gson;

public class ClientService {
	
	private ViewModel model;
	
	public ClientService(String json) {
		model = readJson(json);
	}
	
	public void update(String json) {
		model.update(readJson(json));
	}

	private ViewModel readJson(String jsonContent) {
		ViewModel jsonTranslation = new Gson().fromJson(jsonContent, ViewModel.class);
		return jsonTranslation;
	}
}
