package com.me.TeamName;

import com.me.TeamName.Engine.RenderableEntity;
import com.me.TeamName.Engine.Scene;
import com.me.TeamName.Engine.SceneManager;

public class GameScene extends Scene {
	private GhostManager ghosts;
	
	public GameScene() {
		super("GameScene");
		
	}
	
	public void SceneBegin(){
		super.SceneBegin();
		PlayerCamera thePlayer = new PlayerCamera();
		
		RenderableEntity testEnt = new RenderableEntity("Background");
		//Quick test ent
		testEnt.createFromSprite("Background", "data/Backgrounds/Halloweenparty.png");
		testEnt.setLayer("BackGround");
		
		SceneManager.Scene().addEntity(thePlayer);
		SceneManager.Scene().addEntity(testEnt);
		
		ghosts = new GhostManager();
		
		GrandfartherClock theClock = new GrandfartherClock();
		SceneManager.Scene().addEntity(theClock);
		theClock.setPosition(410,95);
	}
	
	public void Update(float dt){
		super.Update(dt);
		ghosts.Update();
	}
}
