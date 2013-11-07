package com.noahhuppert.night.View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.noahhuppert.night.Night;

public class WorldRenderer {
	World world;
	Environment environment;
	PerspectiveCamera cam;
	AssetManager assets;
	ModelBatch modelBatch;
	Model mainCharecterModel;
	ModelInstance mainCharecter;
	public Array<ModelInstance> instances = new Array<ModelInstance>();

	float width;
	float height;
	boolean loading;

	public WorldRenderer(World world) {
		this.world = world;
		
		environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));
			
		cam = new PerspectiveCamera(67, Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());
		cam.position.set(10f, 10f, 10f);
		cam.lookAt(0, 0, 0);
		cam.near = 0.1f;
		cam.far = 300f;
		cam.update();
		
		modelBatch = new ModelBatch();
		assets = new AssetManager();
		assets.load("data/mainCharecter/mainCharecter.g3db", Model.class);
		
		loading = true;
	}

	public void render() {
		
		if(loading == true && assets.update() == true){
			doneLoading();
		}
		Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

		modelBatch.begin(cam);
		modelBatch.render(instances);
		modelBatch.end();

		world.setRenderer(this);
	}
	
	private void doneLoading() {
		mainCharecterModel = assets.get("data/mainCharecter/mainCharecter.g3db", Model.class);
		mainCharecter = new ModelInstance(mainCharecterModel, "mainCharecter");
		instances.add(mainCharecter);
		
		loading = false;
	}

	public PerspectiveCamera getCamera() {
		return cam;
	}

	public void update() {

	}

	public void dispose() {
		modelBatch.dispose();
		mainCharecterModel.dispose();
		assets.dispose();
	}
}
