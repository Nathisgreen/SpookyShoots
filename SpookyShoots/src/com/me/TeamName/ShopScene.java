package com.me.TeamName;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.me.TeamName.Engine.Renderer;
import com.me.TeamName.Engine.Scene;
import com.me.TeamName.Engine.SceneManager;
import com.me.TeamName.Engine.UI.Button;
import com.me.TeamName.Engine.UI.ScrollView;

public class ShopScene extends Scene {

	private ScrollView scrollView;
	private int scrollLength;
	
	public ShopScene() {
		super("ShopScene");
		
	}
	
	public void SceneBegin(){
		super.SceneBegin();
		
		createScrollView(0);
		
		Array<TextureRegion> thePictures = LevelDataSaver.getPicture();
		for (int i = 0; i < thePictures.size; i++){
			Button aButton = new Button();
			aButton.changeFromTextureRegion(thePictures.get(i));
			aButton.setPosition((Renderer.getCameraSize().x/2) - (thePictures.get(i).getTexture().getWidth()/2), 
								scrollView.getPosition().y + ((thePictures.get(i).getTexture().getHeight() + 30) * i));
			scrollView.add(aButton);
			scrollLength += thePictures.get(i).getTexture().getHeight(); 
		}
		
		scrollView.setMaxScrollVert(-scrollLength);
		
		ButtonShop theBuyButton = new ButtonShop();
		theBuyButton.setPosition(Renderer.getCameraSize().x -theBuyButton.getSourceRectangle().width,
				Renderer.getCameraSize().y -theBuyButton.getSourceRectangle().height);
		
		addEntity(theBuyButton);
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
