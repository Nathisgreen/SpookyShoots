package com.me.TeamName;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import com.me.TeamName.Engine.RenderableEntity;
import com.me.TeamName.Engine.Renderer;
import com.me.TeamName.Engine.SceneManager;

public class CameraFlash extends RenderableEntity {	
	public CameraFlash(){
		super("CameraFlash");
		
		createFromSprite("CameraFlash", "data/Backgrounds/sprFlash.png");
		
		setLayer("Foreground");
	}
	
	public void Update(float dt){
		alpha -= 0.6f * dt;
		
		if (alpha - (0.6f * dt) < 0){
			Delete();
		}
	}
	
}
