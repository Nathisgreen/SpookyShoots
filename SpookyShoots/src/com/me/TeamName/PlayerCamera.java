package com.me.TeamName;

import com.me.TeamName.Engine.Input;
import com.me.TeamName.Engine.RenderableEntity;
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
		position = Input.getTouchedPosition();
		
		if (Input.getTouchedReleased() && canShoot){
			CameraFlash theFlash = new CameraFlash();
			SceneManager.Scene().addEntity(theFlash);
			canShoot = false;
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
