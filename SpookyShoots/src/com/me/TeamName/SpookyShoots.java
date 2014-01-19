package com.me.TeamName;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.me.TeamName.Engine.ContentManager;
import com.me.TeamName.Engine.EntityManager;
import com.me.TeamName.Engine.Input;
import com.me.TeamName.Engine.RenderableEntity;
import com.me.TeamName.Engine.Renderer;
import com.me.TeamName.Engine.Scene;
import com.me.TeamName.Engine.SceneManager;
import com.me.TeamName.Engine.SoundManager;

public class SpookyShoots implements ApplicationListener {

	private float delta;
	
	@Override
	public void create() {		
		ContentManager.Init();
		SceneManager.Init();
		SoundManager.Init();
		Input.Init();
		Renderer.Init(1024, 768);
		RenderableEntity testEnt = new RenderableEntity("test");
		
		LoadContent theContent = new LoadContent();
		
		PlayerCamera thePlayer = new PlayerCamera();
		
		//Quick test ent
		testEnt.createFromSprite("Test", "data/Backgrounds/Halloweenparty.png");
		SceneManager.Scene().addEntity(thePlayer);
		SceneManager.Scene().addEntity(testEnt);

	}

	@Override
	public void dispose() {
		SoundManager.Dispose();
	}

	@Override
	public void render() {		
		delta = Gdx.graphics.getDeltaTime();
		delta = Math.min(delta, 0.1f);
		
		Input.Update(delta);
		SceneManager.Update(delta);
		Renderer.Draw();
	}

	@Override
	public void resize(int width, int height) {
		Renderer.resizeRenderer(width, height);
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
