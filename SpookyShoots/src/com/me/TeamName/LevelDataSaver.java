package com.me.TeamName;

import com.badlogic.gdx.utils.Array;
import com.me.TeamName.Engine.RenderableEntity;

public class LevelDataSaver {

	public static Array<RenderableEntity> pictures = new Array<RenderableEntity>();
	
	public static void addImage(RenderableEntity _aPic){
		pictures.add(_aPic);
	}
	
}
