package com.me.TeamName;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.me.TeamName.Engine.Input;
import com.me.TeamName.Engine.RenderableEntity;
import com.me.TeamName.Engine.Renderer;
import com.me.TeamName.Engine.SceneManager;

public class PlayerCamera extends RenderableEntity {
	
	private float cameraDelayTimer = 3;
	private float cameraDelayTime = 0;
	
	private boolean canShoot = true;
	
	public PlayerCamera(){
		super("Player Camera","cameraShutter", "data/Atlas/pack0/pack0.pack");
		
		setOrigin(sourceRectangle.width/2, sourceRectangle.height/2);
		
		setLayer("Game");
	}

	public void Update(float dt){
		
		Renderer.drawText("testFont", "Film: " + LevelDataSaver.getfilmAmount(), new Vector2(
				20 ,
				30),
				1, 1, 
				1, 1);
		
		position = Input.getTouchedPosition();
		
		if (canShoot){
			setDraw(true);
		}else{
			setDraw(false);
		}
		
		if (Input.getTouchedReleased() && canShoot){
				if (LevelDataSaver.getfilmAmount() != 0){
				 	LevelDataSaver.subtractFilm();
					CameraFlash theFlash = new CameraFlash();
					SceneManager.Scene().addEntity(theFlash);
					canShoot = false;
					
					TextureRegion screenShot = new TextureRegion(ScreenUtils.getFrameBufferTexture(
							(int) (position.x - origin.x), 
							(int) (Renderer.getCameraSize().y - (position.y + origin.y) ), 
							(int) sourceRectangle.width,
							(int) sourceRectangle.height));
					
					LevelDataSaver.addImage(screenShot, 100);
					
					if ( LevelDataSaver.getfilmAmount() == 0){
						SceneManager.switchScene("ShopScene");
					}
				}else{
					SceneManager.switchScene("ShopScene");
				}
		}
		
		if (!canShoot){
			if (cameraDelayTime < cameraDelayTimer){
				cameraDelayTime += 1 * dt;
			}else{
				cameraDelayTime %= cameraDelayTimer; // reset the timer without losing accuracy
				canShoot = true;
			}
		}
		
		
	}
}
