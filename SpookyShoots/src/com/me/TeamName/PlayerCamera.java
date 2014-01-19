package com.me.TeamName;

import com.me.TeamName.Engine.Input;
import com.me.TeamName.Engine.RenderableEntity;

public class PlayerCamera extends RenderableEntity {
	
	public PlayerCamera(){
		super("Player Camera","cameraShutter", "data/Atlas/pack0/pack0.pack");
		
		setOrigin(sourceRectangle.width/2, sourceRectangle.height/2);
	}

	public void Update(float dt){
		position = Input.getTouchedPosition();
	}
}
