package com.noahhuppert.night.Model;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.noahhuppert.night.Night;

public class Entity{
	protected Vector2 position;
	protected float width;
	protected float height;
	protected float rotation;
	protected Vector2 velocity;
	protected boolean stationary;
	protected String texturePath = "data/noTexture.png";
	
	public Entity(Vector2 position, float width, float height, float rotation, Vector2 velocity, boolean stationary){
		this.position = position;
		this.width = width;
		this.height = height;
		this.rotation = rotation;
		this.velocity = velocity;
		this.stationary = stationary;
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
	
	public float getRotation(){
		return rotation;
	}
	
	public Vector2 getVelocity(){
		return velocity;
	}
	
	public boolean getStationary(){
		return stationary;
	}
	
	public String getTexturePath(){
		return texturePath;
	}
	
	//Setters
	public void setPosition(Vector2 position){
		this.position = position;
	}
	
	public void setWidth(float width){
		 this.width = width;
	}
	
	public void setHeight(float height){
		this.height = height;
	}
	
	public void setRotation(float rotation){
		 this.rotation = rotation;
	}
	
	public void setVelocity(Vector2 velocity){
		 this.velocity = velocity;
	}
	
	public void setStationary(boolean stationary){
		 this.stationary = stationary;
	}
	
	public void setTexturePath(String texturePath){
		 this.texturePath = texturePath;
	}
}
