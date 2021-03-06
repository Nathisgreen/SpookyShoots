package com.me.TeamName;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.me.TeamName.Engine.RenderableEntity;
import com.me.TeamName.Engine.Renderer;

public class Ghost extends RenderableEntity {
	private Vector2 moveTo;
	private boolean fadeOut = false;
	private Vector2 startPos;
	
	public Array<Vector2> possiblePossitions = new Array<Vector2>();
	public float velocity = 100;
	
	public void setStartPosition(Vector2 vect){
		startPos = vect;
	}
	//-Constructors-//
	protected Ghost(){
		super("Ghost", "GhostMove","data/Atlas/pack0/pack0.pack");
		if(possiblePossitions.size == 0){
			possiblePossitions.add(new Vector2(
				(int)(Math.random()*1024),
				(int)(Math.random()*768)
			));
			possiblePossitions.add(new Vector2(
				(int)(Math.random()*1024),
				(int)(Math.random()*768)
			));
			possiblePossitions.add(new Vector2(
				(int)(Math.random()*1024),
				(int)(Math.random()*768)
			));
			possiblePossitions.add(new Vector2(
					(int)(Math.random()*1024),
					(int)(Math.random()*768)
				));
			possiblePossitions.add(new Vector2(
					(int)(Math.random()*1024),
					(int)(Math.random()*768)
				));
			possiblePossitions.add(new Vector2(
					(int)(Math.random()*1024),
					(int)(Math.random()*768)
				));
			possiblePossitions.add(new Vector2(
					(int)(Math.random()*1024),
					(int)(Math.random()*768)
				));
			possiblePossitions.add(new Vector2(
					(int)(Math.random()*1024),
					(int)(Math.random()*768)
				));
		}
		moveTo = possiblePossitions.get((int)(Math.random()*possiblePossitions.size));
		//createFromSprite("ghost", "data/ghostcartoon.png");
		alpha = 0.7f;
		if(startPos != null){
			position = startPos;
		}
		startPos = new Vector2( position.x, position.y );
		setLayer("Game");
		
		setOrigin(sourceRectangle.width/2, sourceRectangle.height/2);
	}
	
	public void toggleShowGost(){
		visible = !visible;
	}
	
	@Override
	public void Update(float dt){
		//If you don't want your boundingBox auto size of sprite don't call super and
		//call this method in your update with the values you want
		
		updateBoundingBox(position.x - (origin.x * scale.x), position.y - (origin.y * scale.y),
			size.x * scale.x, size.y * scale.y);
		
		if(moveTo.x < position.x){
			position.x -= velocity * dt;
		}
		if(moveTo.x > position.x){
			position.x += velocity * dt;
		}
		if(moveTo.y < position.y){
			position.y -= velocity * dt;
		}
		if(moveTo.y > position.y){
			position.y += velocity * dt;
		}
		
		float distance = position.dst2(moveTo);
		float totalDistance = startPos.dst2(moveTo);
		alpha = 0.2f+( (distance / totalDistance)) * 0.8f;
	
		if(Utils.getInstance().rangeCheckVector2(moveTo, position, 10)){
			moveTo = possiblePossitions.get(((int)(Math.random()*possiblePossitions.size)));
			startPos = new Vector2( position.x, position.y );
			alpha = 0.7f;
		}
	}
	
	public void Draw(){	
		if (visible){
			Renderer.drawSprite(textureRegion, position, getSourceRectangle(),
					size, rotation, origin, scale.x, scale.y, alpha, color, layer);
		}
	}
}
