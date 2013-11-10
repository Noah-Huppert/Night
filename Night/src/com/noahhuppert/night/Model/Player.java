package com.noahhuppert.night.Model;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;

public class Player extends Entity{
	
	protected float health;
	protected float power;
	
	public Player(Vector2 position, float width, float height, float rotation, Vector2 velocity, boolean stationary, float health, float power) {
		super(position, width, height, rotation, position, stationary);
		this.health = health;
		this.power = power;
	}
	
	//Getters
	public float getHealth(){
		return health;
	}
	
	public float getPower(){
		return power;
	}
	
	//Setters
	public void setHealth(float health){
		health = this.health;
	}
	
	public void setPower(float power){
		power = this.power;
	}
}
