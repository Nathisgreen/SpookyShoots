package com.me.TeamName;

import com.me.TeamName.Engine.ContentManager;
import com.me.TeamName.Engine.Scene;
import com.me.TeamName.Engine.SceneManager;

public class LoadContent {
	
	public LoadContent(){
		
		ContentManager.loadAtlas("data/Atlas/pack0/pack0.pack");
		
		GameScene gameScene = new GameScene();
		//Quick test Scene
		SceneManager.addScene(gameScene);
		SceneManager.switchScene("GameScene");
	}

}
