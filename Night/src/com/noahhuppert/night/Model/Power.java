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
}
