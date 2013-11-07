package com.noahhuppert.night;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Night";
		cfg.useGL20 = false;
		cfg.width = 1080;
		cfg.height = 720;
		
		new LwjglApplication(new Night(), cfg);
	}
}
