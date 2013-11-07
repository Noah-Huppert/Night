package com.noahhuppert.night.Model;

import com.badlogic.gdx.math.Vector2;

public class Entity{
	protected Vector2 position;
	protected float width;
	protected float height;
	
	public Entity(Vector2 position, float width, float height){
		this.position = position;
		this.width = width;
		this.height = height;
	}
	
	//Getters
	public Vector2 getPosition(){
		return position;
	}
	
	public float getWidth(){
		return width;
	}
	
	public float getHeight(){
		return height;
	}
	
	//Setters
	public void setPosition(Vector2 position){
		position = this.position;
	}
	
	public void setWidth(float width){
		width = this.width;
	}
	
	public void setHeight(float height){
		height = this.height;
	}
}
