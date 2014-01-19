package com.me.TeamName;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.me.TeamName.Engine.RenderableEntity;
import com.me.TeamName.Engine.Renderer;

public class Ghost extends RenderableEntity {
	//-Constructors-//
	protected Ghost(){
		super("Entity");
		initialize();
		visible = false;
		
	}
	
	public void toggleShowGost(){
		visible = !visible;
	}

	private void initialize(){
		position = new Vector2(0,0);
		origin = new Vector2(0,0);
		scale = new Vector2(1,1);
		boundingBox = new Rectangle();
		sourceRectangle = new Rectangle();
		visible = true;
		active = true;
		rotation = 0;
		alpha = 1;
		layer = "Default";
		color = new Color(1.0f, 1.0f, 1.0f, 1.0f);
	}
	
	@Override
	public void Update(float dt){
		//If you don't want your boundingBox auto size of sprite don't call super and
		//call this method in your update with the values you want
		
		updateBoundingBox(position.x - (origin.x * scale.x), position.y - (origin.y * scale.y),
			size.x * scale.x, size.y * scale.y);
	}
	
	public void Draw(){	
		if (visible){
			Renderer.drawSprite(textureRegion, position, getSourceRectangle(),
					size, rotation, origin, scale.x, scale.y, alpha, color, layer);
		}
	}
}
