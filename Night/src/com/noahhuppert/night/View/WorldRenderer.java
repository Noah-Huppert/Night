package com.noahhuppert.night.View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
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
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.bullet.collision.btBroadphaseInterface;
import com.badlogic.gdx.physics.bullet.collision.btCollisionDispatcher;
import com.badlogic.gdx.physics.bullet.collision.btCollisionShape;
import com.badlogic.gdx.physics.bullet.collision.btDbvtBroadphase;
import com.badlogic.gdx.physics.bullet.collision.btDefaultCollisionConfiguration;
import com.badlogic.gdx.physics.bullet.collision.btSphereShape;
import com.badlogic.gdx.physics.bullet.collision.btStaticPlaneShape;
import com.badlogic.gdx.physics.bullet.dynamics.btDiscreteDynamicsWorld;
import com.badlogic.gdx.physics.bullet.dynamics.btSequentialImpulseConstraintSolver;
import com.badlogic.gdx.physics.bullet.extras.btBulletWorldImporter;
import com.badlogic.gdx.physics.bullet.linearmath.btDefaultMotionState;
import com.badlogic.gdx.physics.bullet.linearmath.btTransform;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.noahhuppert.night.Night;

public class WorldRenderer {
	World world;
	Environment environment;
	//PerspectiveCamera cam;
	OrthographicCamera cam;
	AssetManager assets;
	ModelBatch modelBatch;
	Model mainCharecterModel;
	ModelInstance mainCharecter;
	public Array<ModelInstance> instances = new Array<ModelInstance>();

	Model model;
	ModelBuilder modelBuilder;
	ModelInstance floor;

	// Bullet
	/*btBroadphaseInterface broadphase = new btDbvtBroadphase();

	btDefaultCollisionConfiguration collisionConfiguration = new btDefaultCollisionConfiguration();
	btCollisionDispatcher dispatcher = new btCollisionDispatcher(
			collisionConfiguration);

	btSequentialImpulseConstraintSolver solver = new btSequentialImpulseConstraintSolver();

	btDiscreteDynamicsWorld dynamicsWorld = new btDiscreteDynamicsWorld(
			dispatcher, broadphase, solver, collisionConfiguration);*/

	String assetPaths[] = new String[1];

	float width;
	float height;
	boolean loading;

	public WorldRenderer(World world) {
		assetPaths[0] = "data/mainCharecter/mainCharecter2.g3db";
		this.world = world;

		// Bullet
		/*dynamicsWorld.setGravity(new Vector3(0, -10, 0));// Set up gravity
		btCollisionShape groundShape = new btStaticPlaneShape(new Vector3(500, 1, 500), 1);//Ground
		btCollisionShape fallShape = new btSphereShape(1);//Sphere
		
		btDefaultMotionState groundMotionState = new btDefaultMotionState(btTransform(new Quaternion(0, 0, 0, 1), new Vector3(0, -1, 0)));*/

		environment = new Environment();
		environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f,
				0.4f, 0.4f, 1f));
		environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f,
				-0.8f, -0.2f));

		/*cam = new PerspectiveCamera(67, Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());
		cam.position.set(50f, 5f, 0f);
		cam.lookAt(0, 5f, 0);
		cam.near = 0.1f;
		cam.far = 300f;
		cam.update();*/
		
		width = (Gdx.graphics.getWidth() / 30);
		height = (Gdx.graphics.getHeight() / 30);
		
		cam = new OrthographicCamera();
		cam.setToOrtho(false, width, height);
		cam.position.set(100f, 5f, 0f);
		cam.update();
		

		Night.advLog("Models", "Loading");
		modelBatch = new ModelBatch();
		assets = new AssetManager();
		assets.load(assetPaths[0], Model.class);

		modelBuilder = new ModelBuilder();

		loading = true;
	}

	public void render() {

		if (loading == true && assets.update() == true) {
			doneLoading();
		}
		Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

		if (loading == false) {
			cam.lookAt(0, 0, 0);
			cam.update();

			modelBatch.begin(cam);
			modelBatch.render(instances, environment);
			modelBatch.end();
		}

		world.setRenderer(this);
	}

	private void doneLoading() {
		mainCharecter = new ModelInstance(
				assets.get(assetPaths[0], Model.class));
		mainCharecter.transform.setToRotation(Vector3.Y, 180).trn(0, 0, 0f);
		instances.add(mainCharecter);

		model = modelBuilder.createBox(500f, 1f, 500f,
				new Material(ColorAttribute.createDiffuse(Color.DARK_GRAY)),
				Usage.Position | Usage.Normal);
		floor = new ModelInstance(model);
		floor.transform.translate(new Vector3(0, -22, 0));
		instances.add(floor);

		loading = false;
		Night.advLog("Models", "Loading Complete");
	}

	/*public PerspectiveCamera getCamera() {
		return cam;
	}*/
	
	public OrthographicCamera getCamera() {
		return cam;
	}

	public void update() {

	}

	public void dispose() {
		// Bullet
		/*broadphase.dispose();
		collisionConfiguration.dispose();
		dispatcher.dispose();
		solver.dispose();
		dynamicsWorld.dispose();*/

		modelBatch.dispose();
		mainCharecterModel.dispose();
		assets.dispose();
	}
}
