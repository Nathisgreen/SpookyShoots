package com.me.TeamName;

import com.badlogic.gdx.math.Vector2;
import com.me.TeamName.Engine.Renderer;
import com.me.TeamName.Engine.Scene;
import com.me.TeamName.Engine.UI.ScrollView;

public class ShopBuyScene extends Scene {

	private ScrollView scrollView;
	private int scrollLength;
	
	public ShopBuyScene() {
		super("ShopBuyScene");
		
	}
	
	public void Update(float dt){
		super.Update(dt);
		
		Renderer.drawText("testFont", "Money: " + LevelDataSaver.getMoney(), new Vector2(
				20 ,
				30),
				0, 0, 
				0, 1);
	}
	
	public void SceneBegin(){
		super.SceneBegin();
		
		createScrollView(0);
	}
	
	private void createScrollView(float _startScroll){
		scrollView = new ScrollView();
		scrollView.setPosition(10,10);
		scrollView.setMinScrollVert(10);
		scrollView.setSize(1000,1000);
		scrollView.setVertScroll(_startScroll);
		scrollView.scrolledAmount.y = _startScroll;
		addEntity(scrollView);
		
		
	}

}
