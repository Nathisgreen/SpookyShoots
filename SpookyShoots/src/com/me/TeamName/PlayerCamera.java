package com.me.TeamName;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.me.TeamName.Engine.BaseEntity;
import com.me.TeamName.Engine.Input;
import com.me.TeamName.Engine.RenderableEntity;
import com.me.TeamName.Engine.Renderer;
import com.me.TeamName.Engine.SceneManager;

public class PlayerCamera extends RenderableEntity {
	
	private float cameraDelayTimer = 3;
	private float cameraDelayTime = 0;
	
	private boolean canShoot = true;
	
	public PlayerCamera(){
		super("Player Camera","cameraShutter", "data/Atlas/pack0/pack0.pack");
		
		setOrigin(sourceRectangle.width/2, sourceRectangle.height/2);
		
		setLayer("Game");
	}

	public void Update(float dt){

		if(// make sure We're witin the Viewport on X Axis
				position.x < 0 || position.x > 1024 ||
				// make sure We're witin the Viewport on Y Axis
				position.y < 0 || position.y > 768
		  ){
			canShoot = false;
		}
	
		Renderer.drawText("testFont", "Film: " + LevelDataSaver.getfilmAmount(), new Vector2(
				20 ,
				30),
				1, 1, 
				1, 1);
		
		position = Input.getTouchedPosition();
		
		if (canShoot){
			setDraw(true);
		}else{
			setDraw(false);
		}
		
		if (Input.getTouchedReleased() && canShoot){
				if (LevelDataSaver.getfilmAmount() != 0){
				 	LevelDataSaver.subtractFilm();
					CameraFlash theFlash = new CameraFlash();
					SceneManager.Scene().addEntity(theFlash);
					canShoot = false;
					
					TextureRegion screenShot = new TextureRegion(ScreenUtils.getFrameBufferTexture(
							(int) ( position.x - origin.x), 
							(int) ( Renderer.getCameraSize().y - (position.y + origin.y) ), 
							(int) sourceRectangle.width,
							(int) sourceRectangle.height));
					
					Array<BaseEntity> allghosts = SceneManager.Scene().getEntityType("Ghost");
					
					System.out.println("ghost: " + allghosts.size);
					
					float totalScore = 0;
					int ghostnum = 0;
					for (int i = 0; i < allghosts.size; i++){
						Ghost aEnt = (Ghost) allghosts.get(i);
						
						if (aEnt.getPosition().x > (position.x - origin.x -aEnt.getOrigin().x) && 
								aEnt.getPosition().y  > (position.y - origin.y -aEnt.getOrigin().y) &&
										aEnt.getPosition().x  < (position.x + origin.x + aEnt.getOrigin().x) && 
										aEnt.getPosition().y  < (position.y + origin.y + aEnt.getOrigin().y )){
							float dist = aEnt.getPosition().dst(position);
							
							float num = 100/dist;
							
							ghostnum++;
							if (num > 0){
								totalScore += num*10;
							}
							
							num = alpha * 100;
						
							
							totalScore += num;
							}
					}
					System.out.println("Ghost in picture " +ghostnum);
					System.out.println("score: " +totalScore);
					Utils.getInstance().money += (int)totalScore;
					LevelDataSaver.addImage(screenShot,(int) totalScore);
					
					if ( LevelDataSaver.getfilmAmount() == 0){
						SceneManager.switchScene("ShopScene");
					}
				}else{
					SceneManager.switchScene("ShopScene");
				}
		}
		
		if (!canShoot){
			if (cameraDelayTime < cameraDelayTimer){
				cameraDelayTime += 1 * dt;
			}else{
				cameraDelayTime %= cameraDelayTimer; // reset the timer without losing accuracy
				canShoot = true;
			}
		}
		
		
	}
}
