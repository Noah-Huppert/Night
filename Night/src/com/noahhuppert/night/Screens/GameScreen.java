package com.noahhuppert.night.Screens;

import com.badlogic.gdx.Screen;
import com.noahhuppert.night.Night;
import com.noahhuppert.night.View.World;
import com.noahhuppert.night.View.WorldRenderer;

public class GameScreen implements Screen{
	
	Night game;
	World world;
	WorldRenderer render;

	public GameScreen(Night game){
		this.game = game;
		world = new World(game);
		render = new WorldRenderer(world);
		
	}
	
	@Override
	public void render(float delta) {
		world.update();
		render.render();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		dispose();
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		world.dispose();
		
	}

}
