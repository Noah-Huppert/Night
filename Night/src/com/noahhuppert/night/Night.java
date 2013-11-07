package com.noahhuppert.night;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.noahhuppert.night.Screens.GameScreen;

public class Night extends Game {
	public static final String VERSION = "0.0.01";
	public static final String LOG = "NoahHuppert.Night";
	public static final String CHANGELOG = 
			"0.0.01 Game created\n";

	@Override
	public void create() {
		setScreen(new GameScreen(this));
	}
	
	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void render() {		
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
			super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}
}

