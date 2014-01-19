package com.me.TeamName;

import com.badlogic.gdx.math.Vector2;
import com.me.TeamName.Engine.Renderer;
import com.me.TeamName.Engine.Scene;
import com.me.TeamName.Engine.UI.Button;
import com.me.TeamName.Engine.UI.ScrollView;

public class ShopBuyScene extends Scene {

	private ScrollView scrollView;
	private int scrollLength;
	
	public ShopBuyScene() {
		super("ShopBuyScene");
		
	}
	
	public void Update(float dt){
		super.Update(dt);
		
		Renderer.drawText("testFont", "Money: " + Utils.getInstance().money, 
				new Vector2(20 , 30), 0, 0, 0, 1);

		Button buyFilmBtn = new Button("buyFilmBtn", "data/Atlas/pack0/pack0.pack");
		buyFilmBtn.setPosition(new Vector2(384,25));
		
		Button buySizeBtn = new Button("buySizeBtn", "data/Atlas/pack0/pack0.pack");
		buySizeBtn.setPosition(new Vector2(384,155));
		
		Button buySpeedBtn = new Button("buySpeedBtn", "data/Atlas/pack0/pack0.pack");
		buySpeedBtn.setPosition(new Vector2(384,285));
		
		Button exitBtn = new Button("exitBtn", "data/Atlas/pack0/pack0.pack");
		exitBtn.setPosition(new Vector2(384,415));
		
		addEntity(buyFilmBtn);
		addEntity(buySizeBtn);
		addEntity(buySpeedBtn);
		addEntity(exitBtn);
	}
	
	
}
