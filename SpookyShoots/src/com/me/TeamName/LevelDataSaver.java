package com.me.TeamName;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class LevelDataSaver {

	private static Array<TextureRegion> pictures = new Array<TextureRegion>();
	private static Array<Integer> scoreValues = new Array<Integer>();
	
	private static int money = 0;
	
	private static int filmAmount = 3;
	
	public static void addImage(TextureRegion _aPic, int _score){
		pictures.add(_aPic);
		scoreValues.add(_score);
	}
	
	public static Array<TextureRegion> getPicture(){
		return pictures;
	}
	
	public static Array<Integer> getScore(){
		return scoreValues;
	}
	
	public static int getMoney(){
		return money;
	}
	
	public static void subtractFilm(){
		filmAmount--;
	}
	
	public static int getfilmAmount(){
		return filmAmount;
	}
	
}
