package com.noahhuppert.night.Model;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class Player extends Entity{
	
	protected float health;
	protected float energy;
	protected Power power;
	protected Array<Power> powerArray;
	protected int powerArrayCounter;
	
	public Player(Vector2 position, float width, float height, float rotation, Vector2 velocity, boolean stationary, float health, float energy ,Power power) {
		super(position, width, height, rotation, position, stationary);
		this.health = health;
		this.energy = energy;
		this.power = power;
		this.powerArray = powerArray;
		this.powerArrayCounter = powerArrayCounter;
	}
	
	//Getters
	public float getHealth(){
		return health;
	}
	
	public float getEnergy(){
		return energy;
	}
	
	public Power getPower(){
		return power;
	}
	
	public Power getNextPower(){
		if(powerArray.size >= powerArrayCounter + 1){
			powerArrayCounter = powerArrayCounter + 1;
			return powerArray.get(powerArrayCounter);
		} else{
			return powerArray.get(0);
		}
	}
	 
	public Power getPrevPower(){
		if(powerArrayCounter - 1 >= 0){
			powerArrayCounter = powerArrayCounter - 1;
			return powerArray.get(powerArrayCounter);
		} else{
			return powerArray.get(powerArray.size);
		}
	}
	//Setters
	public void setHealth(float health){
		health = this.health;
	}
	
	public void setEnergy(float energy){
		energy = this.energy;
	}
	
	public void setPower(Power power){
		power = this.power;
	}
	
	public void addPower(Power power){
		powerArray.add(power);
	}
}
