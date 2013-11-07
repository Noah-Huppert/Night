package com.noahhuppert.night.View;

import com.noahhuppert.night.Night;

public class World {
	Night game;
	World world;
	WorldRenderer wr;
	
	public World(Night game){
		this.game = game;
	}
	
	public void update(){
		
	}
	
	public void setRenderer(WorldRenderer wr) {
		this.wr = wr;
	}
	
	public void dispose() {

	}
}
