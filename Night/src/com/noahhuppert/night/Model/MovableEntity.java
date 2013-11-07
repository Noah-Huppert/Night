package com.noahhuppert.night.Model;

import com.badlogic.gdx.math.Vector2;

public class MovableEntity extends Entity{
	
	protected float rotation;
	protected Vector2 velocity;

	public MovableEntity(Vector2 position, float width, float height, float rotation) {
		super(position, width, height);
		this.rotation = rotation;
		this.velocity = velocity;
	}
	
	//Getters
	public float getRotation(){
		return rotation;
	}
	
	public Vector2 getVelocity(){
		return velocity;
	}
	
	//Setters
	public void setRotation(float rotation){
		rotation = this.rotation;
	}
	
	public void setVelocity(Vector2 velocity){
		velocity = this.velocity;
	}
}
