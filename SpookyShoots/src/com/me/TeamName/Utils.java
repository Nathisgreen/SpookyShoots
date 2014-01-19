package com.me.TeamName;

import com.badlogic.gdx.math.Vector2;

public class Utils {
	static Utils instance;
	
	// constructor
	private Utils(){
	
	}
	
	public static Utils getInstance(){
		if(instance == null){
			instance = new Utils();
		}
		return instance;
	}
	
	public boolean compareVector2(Vector2 Vec1, Vector2 Vec2){
		boolean match = true;
		if(Vec1.x == Vec2.x){ match = false;}
		if(Vec1.y == Vec2.y){ match = false;}
		return match;
	}
	
	public boolean rangeCheckVector2(Vector2 Vec1, Vector2 Vec2, int allowedRange){
		boolean match = true;
		if(Vec1.x < Vec2.x - allowedRange){ match = false;}
		if(Vec1.x > Vec2.x + allowedRange){ match = false;}
		if(Vec1.y < Vec2.y - allowedRange){ match = false;}
		if(Vec1.y > Vec2.y + allowedRange){ match = false;}
		return match;
	}
}
