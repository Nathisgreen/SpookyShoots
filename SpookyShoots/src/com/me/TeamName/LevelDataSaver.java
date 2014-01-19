package com.me.TeamName;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class LevelDataSaver {

	public static Array<TextureRegion> pictures = new Array<TextureRegion>();
	
	public static void addImage(TextureRegion _aPic){
		pictures.add(_aPic);
	}
	
	public static Array<TextureRegion> getPicture(){
		return pictures;
	}
	
}
