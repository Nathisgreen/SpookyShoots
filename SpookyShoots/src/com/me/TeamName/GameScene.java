package com.me.TeamName;

import com.me.TeamName.Engine.RenderableEntity;
import com.me.TeamName.Engine.Scene;
import com.me.TeamName.Engine.SceneManager;
import com.me.TeamName.LevelStuff.Sofa;

public class GameScene extends Scene {

	public GameScene() {
		super("GameScene");
		
	}
	
	public void SceneBegin(){
		super.SceneBegin();
		PlayerCamera thePlayer = new PlayerCamera();
		
		RenderableEntity testEnt = new RenderableEntity("Background");
		//Quick test ent
		testEnt.createFromSprite("Background", "data/Backgrounds/WallpaperBackground.png");
		testEnt.setLayer("BackGround");
		
		SceneManager.Scene().addEntity(thePlayer);
		SceneManager.Scene().addEntity(testEnt);
		
		GrandfartherClock theClock = new GrandfartherClock();
		SceneManager.Scene().addEntity(theClock);
		theClock.setPosition(410,95);
		
		for (int i = 0; i < 10; i++){
			Ghost aGhost = new Ghost();
			addEntity(aGhost);
		}
		
		Sofa aSofa = new Sofa();
		addEntity(aSofa);
		aSofa.setPosition(100,640);
	}

}
