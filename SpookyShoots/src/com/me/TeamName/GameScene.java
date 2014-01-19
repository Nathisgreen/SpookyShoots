package com.me.TeamName;

import com.me.TeamName.Engine.RenderableEntity;
import com.me.TeamName.Engine.Scene;
import com.me.TeamName.Engine.SceneManager;
import com.me.TeamName.LevelStuff.Sofa;

public class GameScene extends Scene {
	private GhostManager ghosts;
	
	public GameScene() {
		super("GameScene");
		
	}
	
	public void SceneBegin(){
		super.SceneBegin();
		PlayerCamera thePlayer = new PlayerCamera();
		
		RenderableEntity testEnt = new RenderableEntity("Background");
		RenderableEntity flareEnt = new RenderableEntity("LenseFlare");
		
		//Quick test ent
		testEnt.createFromSprite("Background", "data/Backgrounds/WallpaperBackground.png");
		testEnt.setLayer("BackGround");

		flareEnt.createFromSprite("Background", "data/lenseFilter_resized.png");
		flareEnt.setLayer("Foreground");
		
		SceneManager.Scene().addEntity(thePlayer);
		SceneManager.Scene().addEntity(testEnt);
		SceneManager.Scene().addEntity(flareEnt);
		
		ghosts = new GhostManager();
		
		GrandfartherClock theClock = new GrandfartherClock();
		SceneManager.Scene().addEntity(theClock);
		theClock.setPosition(410,95);
		
		Sofa aSofa = new Sofa();
		addEntity(aSofa);
		aSofa.setPosition(100,640);
	}
	
	public void Update(float dt){
		super.Update(dt);
		ghosts.Update();
	}
}
