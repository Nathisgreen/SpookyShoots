package com.me.TeamName;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import com.me.TeamName.Engine.Input;
import com.me.TeamName.Engine.RenderableEntity;
import com.me.TeamName.Engine.Renderer;
import com.me.TeamName.Engine.SceneManager;

public class PlayerCamera extends RenderableEntity {
	
	private float cameraDelayTimer = 3;
	private float cameraDelayTime = 0;
	
	private boolean canShoot = true;
	
	private int shotsLeft = 3;
	
	public PlayerCamera(){
		super("Player Camera","cameraShutter", "data/Atlas/pack0/pack0.pack");
		
		setOrigin(sourceRectangle.width/2, sourceRectangle.height/2);
		
		setLayer("Game");
	}

	public void Update(float dt){
		position = Input.getTouchedPosition();
		
		if (canShoot){
			setDraw(true);
		}else{
			setDraw(false);
		}
		
		if (Input.getTouchedReleased() && canShoot){
				shotsLeft--;
				CameraFlash theFlash = new CameraFlash();
				SceneManager.Scene().addEntity(theFlash);
				canShoot = false;
				
				TextureRegion screenShot = new TextureRegion(ScreenUtils.getFrameBufferTexture(
						(int) (position.x - origin.x), 
						(int) (Renderer.getCameraSize().y - (position.y + origin.y) ), 
						(int) sourceRectangle.width,
						(int) sourceRectangle.height));
				
				LevelDataSaver.addImage(screenShot);
				
				//RenderableEntity test = new RenderableEntity("test");
				//test.changeFromTextureRegion(screenShot);
				//test.setLayer("Foreground");
				//LevelDataSaver.addImage(test);
				//SceneManager.Scene().addEntity(test);
				//test.setPosition(100,100);
				
				if (shotsLeft == 0){
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
