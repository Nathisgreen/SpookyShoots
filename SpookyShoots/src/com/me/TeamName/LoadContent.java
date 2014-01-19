package com.me.TeamName;

import com.me.TeamName.Engine.ContentManager;
import com.me.TeamName.Engine.Scene;
import com.me.TeamName.Engine.SceneManager;

public class LoadContent {
	
	public LoadContent(){
		
		ContentManager.loadAtlas("data/Atlas/pack0/pack0.pack");
		
		//Quick test Scene
		SceneManager.addScene(new Scene("TestScene"));
		SceneManager.switchScene("TestScene");
	}

}
