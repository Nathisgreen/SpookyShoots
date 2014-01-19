package com.me.TeamName;

import com.badlogic.gdx.utils.Array;
import com.me.TeamName.Engine.SceneManager;

public class GhostManager {
	private long startTime = System.currentTimeMillis() / 1000L;
	private int level = 0;
	
	public void setLevel(int lvl){
		level = lvl;
	}
	
	public void Update(){
		long gameRunningFor = (System.currentTimeMillis() / 1000L)-startTime;
		if(gameRunningFor == 5){
			SceneManager.Scene().addEntity(new Ghost());
		}
		if(gameRunningFor == 10){
			SceneManager.Scene().addEntity(new Ghost());
		}
		if(gameRunningFor == 15){
			SceneManager.Scene().addEntity(new Ghost());
		}
		if(gameRunningFor == 25){
			SceneManager.Scene().addEntity(new Ghost());
		}
	}
}
