package com.noahhuppert.night.Model;

public class Power {
	
	protected float level;
	protected float powerDrain;
	
	public Power(float level, float powerDrain){
		this.level = level;
		this.powerDrain = powerDrain;
	}
	
	//Getters
	public float getLevel(){
		return level;
	}
	
	public float getPowerDrain(){
		return powerDrain;
	}
	
	//Setters
	public void setLevel(float level){
		level = this.level;
	}
	
	public void setPowerDrain(float powerDrain){
		powerDrain = this.powerDrain;
	}
	
	//Methods
	public void touchDown(int screenX, int screenY, int pointer, int button, Player player){
		
	}
	
	public void touchUp(int screenX, int screenY, int pointer, int button, Player player){
		
	}
	
	public void touchDragged(int screenX, int screenY, int pointer, Player player){
		
	}
	
	public void mouseMoved(int screenX, int screenY, Player player){
		
	}
	
	public void keyDown(int keycode, Player player){
		
	}
	
	public void keyUp(int keycode, Player player){
		
	}
}
