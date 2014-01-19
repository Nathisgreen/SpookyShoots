package com.me.TeamName;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import com.me.TeamName.Engine.RenderableEntity;
import com.me.TeamName.Engine.Scene;
import com.me.TeamName.Engine.SceneManager;

public class CameraFlash extends RenderableEntity {
	
	public CameraFlash(){
		super("CameraFlash");
		
		createFromSprite("CameraFlash", "data/Backgrounds/sprFlash.png");
		
		setLayer("Foreground");
		
		TextureRegion screenShot = new TextureRegion(ScreenUtils.getFrameBufferTexture());
		
			RenderableEntity test = new RenderableEntity("test");
			test.changeFromTextureRegion(screenShot);
			test.setLayer("Foreground");
			SceneManager.Scene().addEntity(test);
		}
	
	public void Update(float dt){
		alpha -= 0.6f * dt;
		
		if (alpha - (0.6f * dt) < 0){
			Delete();
		}
	}
	
}
