package com.me.TeamName;

import com.badlogic.gdx.math.Vector2;
import com.me.TeamName.Engine.ContentManager;
import com.me.TeamName.Engine.Renderer;
import com.me.TeamName.Engine.SceneManager;
import com.me.TeamName.Engine.UI.Button;


public class ButtonShop extends Button {

	public ButtonShop() {
		super("sprButton","data/Atlas/pack0/pack0.pack");
	}
	
	@Override
	public void Update(float dt){
		super.Update(dt);
		
		Renderer.drawText("testFont", "Buy Shit", new Vector2(
				position.x + size.x/2 - ContentManager.getFont("testFont").getBounds("Buy Shit").width/2 ,
				position.y + size.y/2 - ContentManager.getFont("testFont").getBounds("Buy Shit").height/2),
				0, 0, 
				0, 1);
	}
	
	@Override
	public void TouchedReleased(){
		super.TouchedReleased();
		
		SceneManager.switchScene("ShopBuyScene");
	}

}