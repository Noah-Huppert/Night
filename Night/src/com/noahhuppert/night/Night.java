package com.noahhuppert.night;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
import com.badlogic.gdx.physics.bullet.Bullet;
import com.noahhuppert.night.Screens.GameScreen;

public class Night extends Game {
	public static final String VERSION = "0.0.01";
	public static final String LOG = "NoahHuppert.Night";
	public static final String CHANGELOG = 
			"0.0.01 Game created\n";
	public static int logTagsCount = 3;
	public static String logTagNames[] = new String[logTagsCount];
	public static Boolean logTags[] = new Boolean[logTagsCount];

	@Override
	public void create() {
		setLogTags();
		Bullet.init();
		advLog("Bullet", "Initialized");
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
	
	public static void log(String logText){
		System.out.println(LOG + ".Misc: " + logText);
	}
	
	public static void advLog(String tag, String logText){
		if(logTags[Arrays.asList(logTagNames).indexOf(tag)] == true ){
			System.out.println(LOG + "." + tag + ": " + logText);
		}
	}
	
	public void setLogTags(){
		logTagNames[0] = "Misc";
		logTags[0] = true;
		
		logTagNames[1] = "Bullet";
		logTags[1] = true;
		
		logTagNames[2] = "Models";
		logTags[2] = true;
	}
}

