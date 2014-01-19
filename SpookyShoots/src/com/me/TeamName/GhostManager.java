package com.me.TeamName;

import com.badlogic.gdx.utils.Array;
import com.me.TeamName.Engine.SceneManager;

public class GhostManager {
	private long startTime = System.currentTimeMillis() / 1000L;
	private int level = 0;
	private boolean done = false;
	
	public void setLevel(int lvl){
		level = lvl;
	}
	
	public void Update(){
		long gameRunningFor = (System.currentTimeMillis() / 1000L)-startTime;
		if(!done && gameRunningFor == 5){
			SceneManager.Scene().addEntity(new Ghost());
			done = true;
		}
		if(done && gameRunningFor == 6){ done = !done; }
		if(!done && gameRunningFor == 10){
			SceneManager.Scene().addEntity(new Ghost());
			done = true;
		}
		if(done && gameRunningFor == 11){ done = !done; }
		if(!done && gameRunningFor == 15){
			SceneManager.Scene().addEntity(new Ghost());
			done = true;
		}
		if(done && gameRunningFor == 16){ done = !done; }
		if(!done && gameRunningFor == 25){
			SceneManager.Scene().addEntity(new Ghost());
			done = true;
		}
		if(done && gameRunningFor == 27){ done = !done; }
		if(!done && gameRunningFor == 28){
			SceneManager.Scene().addEntity(new Ghost());
			done = true;
		}
		if(done && gameRunningFor == 29){ done = !done; }
		if(!done && gameRunningFor == 30){
			SceneManager.Scene().addEntity(new Ghost());
			done = true;
		}
	}
}
