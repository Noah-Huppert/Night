package com.noahhuppert.night.View;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.noahhuppert.night.Night;
import com.noahhuppert.night.Model.Entity;
import com.noahhuppert.night.Model.MEntity;
import com.noahhuppert.night.Model.Player;
import com.noahhuppert.night.Model.Power;
import com.esotericsoftware.*;

public class World {
	Night game;
	World world;
	WorldRenderer wr;
	
	Array<Entity> entities = new Array<Entity>();
	
	Entity floor;
	Player player;
	Power nullPower;
	
	public World(Night game){
		this.game = game;
		
		nullPower = new Power(0, 0);
		
		floor = new Entity(new Vector2(0, -4), 5, 1, 0, new Vector2(0, 0), true);
		entities.add(floor);
		player = new Player(new Vector2(0, 0), 1, 1, 0, new Vector2(0, 0), false, 100, 100, nullPower);
		player.setTexturePath("data/head.png");
	}
	
	public void update(){
		
	}
	
	public void setRenderer(WorldRenderer wr) {
		this.wr = wr;
	}
	
	public void dispose() {
		
	}
	
	public Array<Entity> getEntities(){
		return entities;
	}
	
	public Player getPlayer(){
		return player;
	}
}
