package com.me.TeamName;

import com.me.TeamName.Engine.RenderableEntity;

public class CameraFlash extends RenderableEntity {
	
	public CameraFlash(){
		super("CameraFlash");
		
		createFromSprite("CameraFlash", "data/Backgrounds/sprFlash.png");
		
		setLayer("Foreground");
	}
	
	public void Update(float dt){
		alpha -= 0.6f * dt;
		
		if (alpha < 0){
			Delete();
		}
	}
	
}
